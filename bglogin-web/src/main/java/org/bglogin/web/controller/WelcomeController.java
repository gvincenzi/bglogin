package org.bglogin.web.controller;

import java.security.Principal;

import org.bglogin.commons.enums.BGLoginErrorEnum;
import org.bglogin.web.enums.LoginMessageKeyEnum;
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
		model.addObject("welcomeMessage", LoginMessageKeyEnum.LOGIN_USER_OK.getKey());
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = { "/admin**" }, method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("welcomeMessage", LoginMessageKeyEnum.LOGIN_ADMIN_OK.getKey());
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", BGLoginErrorEnum.LOGIN_ERROR.getKey());
		}

		if (logout != null) {
			model.addObject("msg", LoginMessageKeyEnum.LOGIN_LOGOUT_OK.getKey());
		}
		model.setViewName("login");

		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		model.addObject("errorMessage", BGLoginErrorEnum.LOGIN_PERMISSION_ERROR.getKey());
		model.setViewName("errors/403");
		return model;

	}

}
