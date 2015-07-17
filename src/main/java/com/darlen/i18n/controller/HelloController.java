package com.darlen.i18n.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@RequestMapping("/i18n")
@Controller
public class HelloController {
	
	private static final Logger logger = Logger.getLogger(HelloController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * http://localhost:8180/i18nDemo/i18n/switchLang/en
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Info:Welcome home! The client locale is {"+locale+"}.");
		logger.debug("Debug:Welcome home! The client locale is {"+locale+"}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
