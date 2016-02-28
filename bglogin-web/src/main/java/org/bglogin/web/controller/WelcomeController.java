package org.bglogin.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * WelcomeController
 * 
 * @author Giuseppe Vincenzi
 *
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController {
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("welcomeMessage", "Welcome in USER area");
		model.setViewName("welcome");
		return model;

	}

	@RequestMapping(value = { "/admin**" }, method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("welcomeMessage", "Welcome in ADMIN restricted area");
		model.setViewName("welcome");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and/or password");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("errorMessage", user.getName() + ", you do not have permissions to access this page!");
		} else {
			model.addObject("errorMessage", "You do not have permission to access this page!");
		}

		model.setViewName("errors/403");
		return model;

	}

}
