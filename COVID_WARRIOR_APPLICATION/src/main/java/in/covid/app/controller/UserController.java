package in.covid.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.covid.app.command.LoginCommand;
import in.covid.app.command.UserCommand;
import in.covid.app.domain.User;
import in.covid.app.exception.UserBlockedException;
import in.covid.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if (loggedInUser == null) {

				m.addAttribute("err", "Login Failed! Enter valid credentials.");
				return "index";
			} else

			{
				if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {

					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				} else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {

					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				} else {

					m.addAttribute("err", "Invalid User ROLE");
					return "index";
				}
			}
		} catch (UserBlockedException ex) {

			m.addAttribute("err", ex.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}

	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "dashboard_user";
	}

	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin";
	}

	@RequestMapping(value = "/admin/users")
	public String getUserList(Model m) {
		m.addAttribute("userList", userService.getUserList());
		return "users";
	}

	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";
	}

	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "Username is already registered. Please select another username.");
			return "reg_form";
		}
	}

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}

}
