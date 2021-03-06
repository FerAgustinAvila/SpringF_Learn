package org.ferdev.springboot.web.app.controllers;

//import java.util.ArrayList;
import java.util.Arrays;

import org.ferdev.springboot.web.app.models.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexController {
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "/home", ""})
/*1*/	
	public String index(Model model) {
//2	public String index(ModelMap model) {
//3	public String index(Map<String, Object> model) {
//4	public ModelAndView index(ModelAndView mv) {
/*1,2*/		
		model.addAttribute("titulo", "Learn Spring Model o ModelMap");
//3		model.put("titulo", "Learn Spring Map");
//4		mv.addObject("titulo", "Learn Spring Model and View");
//4		mv.setViewName("index");
//4		return mv;
		
		return "index";
	}
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		User user = new User();
		user.setName("Fernando");
		user.setLastName("Avila");
		user.setEmail("fernandoavila@correo.com");
		
		model.addAttribute("user", user);
		model.addAttribute("titulo", "Perfil usuario: ".concat(user.getName()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {		

//		List<User> users = new ArrayList<>();
//		users.add(new User("Fernando", "Avila", "fernandoavila@correo.com"));
//		users.add(new User("Agustin", "gomez", "agustingomez@correo.com"));
//		users.add(new User("Gladys", "Noemi", "gladys@correo.com"));
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	@ModelAttribute("users")
	public List<User> addUsers(){
		List<User> users = Arrays.asList(new User("Fernando", "Avila", "fernandoavila@correo.com"),
				 new User("Agustin", "gomez", "agustingomez@correo.com"),
				 new User("Gladys", "Noemi", "gladys@correo.com"),
				 new User("Ross", "Torres", "ross@correo.com")
				);
		
		return users;
	}

}
