package in.covid.app.service;

import java.util.List;

import in.covid.app.domain.User;
import in.covid.app.exception.UserBlockedException;

public interface UserService {

	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;

	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;

	public void register(User u);

	public User login(String loginName, String password) throws UserBlockedException;

	public List<User> getUserList();

	public void changeLoginStatus(Integer userId, Integer loginStatus);

	public Boolean isUsernameExist(String username);

}
