package in.covid.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.covid.app.config.SpringRootConfig;
import in.covid.app.dao.UserDAO;

public class TestUserDAODelete {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		userDAO.delete(2);
		System.out.println("--------Data Deleted------");
	}
}
