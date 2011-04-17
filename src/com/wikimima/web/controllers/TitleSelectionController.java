package com.wikimima.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wikimima.services.TitleRetreivalException;
import com.wikimima.services.TitleGenerationService;
import com.wikimima.web.commands.SelectTitleCommand;

@Controller
public class TitleSelectionController {

	@Autowired
	@Qualifier("TitleService")
	private TitleGenerationService service;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView getRandomTitle() throws TitleRetreivalException {
		return _getRandomTitle();
	}

	@RequestMapping(value = "/skip", method = RequestMethod.POST)
	public ModelAndView skipTitle(SelectTitleCommand command)
			throws TitleRetreivalException {
		return _getRandomTitle();
	}

	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public ModelAndView playTitle(SelectTitleCommand command)
			throws TitleRetreivalException {
		ModelAndView mav = new ModelAndView("play");
		mav.addObject("title", command.getTitle());
		return mav;
	}

	private ModelAndView _getRandomTitle() throws TitleRetreivalException {
		SelectTitleCommand command = new SelectTitleCommand();
		ModelAndView mav = new ModelAndView("rand");
		String randomTitle = service.getRandomTitle();
		command.setTitle(randomTitle);
		mav.addObject("SelectTitleCommand", command);
		return mav;
	}

}
