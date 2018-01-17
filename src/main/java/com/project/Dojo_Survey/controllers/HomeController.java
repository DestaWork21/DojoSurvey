package com.project.Dojo_Survey.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

@RequestMapping("/")

public class HomeController {

	@RequestMapping("")

	public String home() {

		return "index";

	}

	  @PostMapping("/login")

      public String login(@RequestParam(value="name") String name, @RequestParam(value="dojolocation") String dojolocation,@RequestParam(value="favlang") String favlang,@RequestParam(value="text_field") String text_field,HttpSession session) {

            session.setAttribute("name",name);

            session.setAttribute("dojolocation",dojolocation);

            session.setAttribute("favlang",favlang);

            session.setAttribute("text_field",text_field);

            return "redirect:/dashboard_view/";

      }

	  @Controller

	  public class DashboardController {

	      @RequestMapping("/dashboard_view")

     

	      public String dashboard(Model model,HttpSession session) {

	    	  	System.out.println(session.getAttribute("favlang"));

	    	  	if (session.getAttribute("favlang").equals("Java")) {

	    	  		System.out.println(session.getAttribute("favlang"));
    	  		

	    	  		return "java";
					// if you choose Jave it reder java.jsp otherwise render dashboard
	    	  	}



	        return "dashboard";

	      }

	  }

	  

}

	
