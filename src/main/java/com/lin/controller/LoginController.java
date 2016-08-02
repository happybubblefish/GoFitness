package com.lin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lin.model.Authority;
import com.lin.model.Member;
import com.lin.model.UserCredentials;
import com.lin.service.AuthorityService;
import com.lin.service.LoginService;
import com.lin.service.MemberService;
import com.lin.service.UserCredentialsService;
import com.lin.validator.MemberValidator;
import com.lin.validator.UserCredentialsValidator;

@Controller
@SessionAttributes("member")
public class LoginController {

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private UserCredentialsService userCredentialsService;

	@Autowired
	private UserCredentialsValidator userCredentialsValidator;

	@Autowired
	private MemberValidator memberValidator;

	@Autowired
	private LoginService loginService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// For 403 - Authentication error
	// @RequestMapping(value = "/403", method = RequestMethod.GET)
	// public String error403(ModelMap model) {
	// return "403";
	// }

	// No need to add .html because in web.xml <servlet-mapping> has indicated
	// to add *.html <url-pattern>

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String initLogin() {
	//
	// System.out.println("Init method.");
	//
	// return "index";
	// }

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error) {
		System.out.println("Init method.");
		System.out.println("I'm in the login method.");

		if (error != null)
			model.addAttribute("error", "Your username or password is invalid.");

		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String postLogin() {

		System.out.println("After the login method.");

		return "index";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String preRegistration(Model model) {
		model.addAttribute("userCredentials", new UserCredentials());
		System.out.println("Before registration");

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postRegistration(@Valid @ModelAttribute("userCredentials") UserCredentials userCredentials,
			BindingResult bindingResult) {
		userCredentialsValidator.validate(userCredentials, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));

		Set<Authority> authSet = new HashSet<Authority>();
		userCredentials.setAuthorities(authSet);

		List<Authority> authorities = authorityService.findAllAuthorities();

		for (Authority au : authorities) {
			if (au.getName().equals("ROLE_USER")) {
				userCredentials.getAuthorities().add(au);
				userCredentials.setEnabled(true);
				au.getUserCredentials().add(userCredentials);
				authorityService.save(au);

				break;
			}
		}

		loginService.autologin(userCredentials.getUsername(), userCredentials.getPasswordConfirm());

		return "redirect:/index.html";
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String preEditProfile(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("member");

		if (member == null) {
			member = new Member();
		}

		model.addAttribute("member", member);

		return "profile";
	}

	@RequestMapping(value = "profile", method = RequestMethod.POST)
	public String postEditProfile(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) {
		memberValidator.validate(member, bindingResult);

		if (bindingResult.hasErrors()) {
			for (Object object : bindingResult.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;

					System.out.println(fieldError.getCode());
				}

				if (object instanceof ObjectError) {
					ObjectError objectError = (ObjectError) object;

					System.out.println(objectError.getCode());
				}
			}

			return "profile";
		}

		String username = loginService.findLoggedInUsername();
		UserCredentials userCredentials = userCredentialsService.findByUsername(username);

		member.setUsername(username);
		member.setUserCredentials(userCredentials);

		userCredentials.setMember(member);
		memberService.save(member);

		return "index";
	}

	// For login failed
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {

		// Set the error flag so that the login.jsp <c:if
		// test="${not empty error }"> will pick up
		model.addAttribute("error", "true");

		return "login";
	}

	// For logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, SessionStatus status, HttpServletRequest request,
			HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// session.invalidate();

			// This is for destroying spring session. session.invalidate() is
			// working for SessionAttribute("")
			status.setComplete();
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "login";
	}
}
