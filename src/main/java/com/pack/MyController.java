package com.pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@Autowired
	TestDAO edao;
	
	@RequestMapping("/hello1")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) {
		
		Employee e=new Employee();
		int rNo=Integer.parseInt(request.getParameter("rNo"));
		String name=request.getParameter("name");
		int sal=Integer.parseInt(request.getParameter("sal"));
		
		e.setrNo(rNo);
		e.setName(name);
		e.setSal(sal);
		
		int i=edao.saveData(e);
		if(i>0) {
			System.out.println("success!");
		}
		else
			System.out.println("epic fail!");
		
		ModelAndView mv=new ModelAndView("display");
		mv.addObject("i", i);
		return mv;
		
	}

}
