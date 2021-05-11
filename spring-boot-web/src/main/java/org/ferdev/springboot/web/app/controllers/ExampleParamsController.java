package org.ferdev.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "text", required = false, defaultValue = "No se mando ningun parametro") String text, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + text);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String regards, @RequestParam Integer number, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + regards + "' y el numero es '" + number + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String regards = request.getParameter("regards");
		Integer number = null;
		try {
			number = Integer.parseInt(request.getParameter("number")) ;			
		} catch (NumberFormatException e) {
			number = 0;
		}
		model.addAttribute("resultado", "El saludo enviado es: '" + regards + "' y el numero es '" + number + "'");
		return "params/ver";
	}
	
	

}
