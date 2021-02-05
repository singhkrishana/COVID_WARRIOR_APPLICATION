package in.covid.app.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.covid.app.config.SpringRootConfig;
import in.covid.app.dao.UserDAO;
import in.covid.app.domain.User;

public class TestUserDAOFindAll {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);

		List<User> users = userDAO.findAll();
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getName() + " " + u.getRole());

		}

	}
}
