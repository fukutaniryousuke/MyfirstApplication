package com.example.demo.app.inquiry;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entiry.Inquiry;
import com.example.demo.servise.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	private final InquiryService inquiryService;

	@Autowired
	public InquiryController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Inquiry> list = inquiryService.getAll();
		
		model.addAttribute("inquiryList", list);
		model.addAttribute("title", "Inquiry Index");
		
		return "inquiry/index-boot";
	}

	@GetMapping("/form")
	public String form(InquiryForm inquiryForm,
			Model model,
			@ModelAttribute("complete") String complete) {
		//		model.addAttribute("inquiryForm", new InquiryForm());
		model.addAttribute("title", "Inquiry Form");

		return "inquiry/form-boot";
	}

	@PostMapping("/form")
	public String formGoBack(InquiryForm inquiryForm,
			Model model) {
		//		model.addAttribute("inquiryForm", inquiryForm);
		model.addAttribute("title", "Inquiry Form");

		return "inquiry/form-boot";
	}

	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) { //errorがあるとtrueとなる
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form-boot";//エラーがある場合
		}
		model.addAttribute("title", "Confirm Form");
		return "inquiry/confirm-boot";//エラーがない場合
	}

	@PostMapping("/complete")
	public String complete(@Validated InquiryForm inquiryform, //HTMLの書き換え防止策
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) { //errorがあるとtrueとなる
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form-boot";//エラーがある場合
		}
		Inquiry inquiry = new Inquiry();
		inquiry.setName(inquiryform.getName());
		inquiry.setEmail(inquiryform.getEmail());
		inquiry.setContents(inquiryform.getContents());
		inquiry.setCreated(LocalDateTime.now());

		inquiryService.save(inquiry);
		redirectAttributes.addAttribute("complete", "Registered");
		return "redirect:/inquiry/form";
	}
}
