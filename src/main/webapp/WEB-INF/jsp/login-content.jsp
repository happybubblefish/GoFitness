<%@ include file="commonCssJs.jsp" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- onload='document.f.j_username.focus();' -->

<div class="container">
	<div class="row">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<h1 class="text-center login-title">Sign in to continue to
				Bootsnipp</h1>
			<div class="account-wall">
				<img class="profile-img"
					src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
					alt="">
				<form action="${contextPath}/login.html" name="f" method="post" class="form-signin">
					<div class="form-group ${ error != null ? 'has-error' : '' }">
						<input class="form-control" type="text" id="username" name="username" placeholder="Username" /> 
						<input class="form-control" type="password" id="password" name="password" placeholder="Password"/>
						<button>Sign in</button>
						<label class="checkbox pull-left"> 
						<input type="checkbox" value="remember-me"/> Remember me
						</label> <a href="#" class="pull-right need-help">Need help? </a><span
							class="clearfix"></span> 
							<span>${ error }</span> 
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
				</form>
			</div>
			<h4 class="text-center">
				<a href="http://localhost:8080/FitnessTracker/registration.html" class="text-center new-account">Create
					an account</a>
			</h4>
		</div>
	</div>
</div>