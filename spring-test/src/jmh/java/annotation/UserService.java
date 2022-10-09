package annotation;

import org.springframework.core.testfixture.stereotype.Component;

@Component
public class UserService {

	public void sayHi(String name){
		System.out.println("hi " + name);
	}
}