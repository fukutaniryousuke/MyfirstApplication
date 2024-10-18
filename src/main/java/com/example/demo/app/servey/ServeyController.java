package com.example.demo.app.servey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller  //コントローラーとしての役割を示す
@RequestMapping("/servey")
public class ServeyController {

	@GetMapping("/form")
	public String form(ServeyForm serveyForm,
			Model model,
			@ModelAttribute("complete") String complete) {
		model.addAttribute("title", "Servey Form");
		return "servey/form";
	}

	@PostMapping("/form")
	public String formGoBack(ServeyForm serveyForm, Model model) {
		model.addAttribute("title", "Servey Form");
		return "servey/form";
	}

	@PostMapping("/confirm")
	public String confirm(@Validated ServeyForm serveyform,
			BindingResult result,
			Model model) {
		//エラーがあればフォーム画面へ
		if (result.hasErrors()) {
			model.addAttribute("title", "Servey Form");
			return "servey/form";
		}
		//エラーがなければ確認画面へ
		model.addAttribute("title", "Confirm Form");
		return "servey/confirm";
	}

	@PostMapping("/complete")
	public String complete(@Validated ServeyForm serveyform, //HTMLの書き換え防止策
			BindingResult result,
			Model model,
			//FLASHスコープが使用できるようになる
			RedirectAttributes redirectAttributes) {
		//エラーがあればフォーム画面へ
		if (result.hasErrors()) {
			model.addAttribute("title", "Servey Form");
			return "servey/form";
		}
		//エラーがなければフォーム画面へリダイレクト
		redirectAttributes.addAttribute("complete", "Registered!!");
		return "redirect:/servey/form";
	}
}
