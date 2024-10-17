package com.example.demo.app.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("inquiryForm", new InquiryForm());
		model.addAttribute("title", "Inquiry Form");

		return "inquiry/form";
	}

	@PostMapping("/form")
	public String formGoBack(Model model) {
		model.addAttribute("title", "Inquiry Form");

		return "inquiry/form";
	}

	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {
		if (result.hasErrors()) { //errorがあるとtrueとなる
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form";//エラーがある場合
		}
		model.addAttribute("title", "Confirm Form");
		return "inquiry/confirm";//エラーがない場合
	}
}
