package com.worldline.democontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PropertySource("classpath:/bank.properties")
public class HelloController {
	@Value("${bank.title}")String title;
	@Value("${bank.welcome}")String welcome;
	
	@GetMapping("/showform")
	public String sayHello(Model model) {
		model.addAttribute("title",title);
		return "views/account";
	}
	
	@PostMapping("/save")
	public String save(Model model,Account account) {
		model.addAttribute("acct",account);
		model.addAttribute("welcome",welcome);
		return "views/success";
	}
}
//create view folder under src/main/resourc