package in.covid.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.covid.app.config.SpringRootConfig;
import in.covid.app.dao.UserDAO;
import in.covid.app.domain.User;

public class TestUserDAOSave {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);

		User u = new User();
		u.setName("Amit");
		u.setPhone("9303580884");
		u.setEmail("amit@ezeon.net");
		u.setAddress("Mumbai");
		u.setLoginName("amit");
		u.setPassword("amit123");
		u.setRole(1);
		u.setLoginStatus(1);
		userDAO.save(u);
		System.out.println("--------Data Saved------");
	}
}
