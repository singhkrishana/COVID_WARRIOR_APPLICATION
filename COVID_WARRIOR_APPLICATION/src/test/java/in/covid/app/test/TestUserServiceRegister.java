package in.covid.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.covid.app.config.SpringRootConfig;
import in.covid.app.domain.User;
import in.covid.app.service.UserService;

public class TestUserServiceRegister {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);

		User u = new User();
		u.setName("Nitin");
		u.setPhone("55555555");
		u.setEmail("nitin@ezeon.net");
		u.setAddress("Mumbai");
		u.setLoginName("nitin");
		u.setPassword("nitin123");
		u.setRole(UserService.ROLE_ADMIN);
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(u);
		System.out.println("--------User Registered Successfully------");
	}
}
