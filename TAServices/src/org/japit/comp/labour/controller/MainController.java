/**
 * 
 */
package org.japit.comp.labour.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sk sanjay
 *
 */

@Controller
@Scope("request")
public class MainController {
	
	@RequestMapping(value={ "/", "/index" }, method = RequestMethod.GET)
	public String homePage(Model model){
		model.addAttribute("indexpageattribute","this is index page");
		return "indexPage";
	}
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String errorPage(Model model){
		model.addAttribute("errorattribute","this is error page");
		return "errorPage";
	}
	
}
