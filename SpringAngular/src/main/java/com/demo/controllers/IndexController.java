package com.demo.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController implements ErrorController{

    private static final String PATH = "/error";
    
    @RequestMapping(value = PATH)
    public String error() {
        return "error";
    }

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}


	@Override
	public String getErrorPath() {
		return PATH;
	}

}
