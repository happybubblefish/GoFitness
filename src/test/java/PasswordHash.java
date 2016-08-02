import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Activity;
import com.lin.service.ExerciseService;


public class PasswordHash {
	
	@Autowired
	@Qualifier("exerciseService")
	private ExerciseService exerciseService;
	
	@Test
	public void testAllActivities(){
		List<Activity> alt = exerciseService.findAllActivities();
		
		for(Activity a : alt){
			System.out.println(a.getName());
		}
	}

	@Test
	public void testMD5Hash() {
		String password = "123";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hashedPassword = passwordEncoder.encodePassword(password, null);
		System.out.println(hashedPassword);
	}
	
	@Test
	public void testBCryptHash(){
		String password = "123";
		BCryptPasswordEncoder bcCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = bcCryptPasswordEncoder.encode(password);
		System.out.println(hashedPassword);
	}

}
