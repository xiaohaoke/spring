package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.testfixture.stereotype.Component;

@Component
public class ManagerService {
	@Autowired
	private UserService userService;

	public void greet(String name){
		userService.sayHi(name);
	}
}
