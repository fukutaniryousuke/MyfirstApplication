package com.example.demo.app;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/sample")
public class SampleController {
	public final JdbcTemplate jdbcTemplate;

	public SampleController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//コメント確認用
	@GetMapping("/test")
	public String test(Model model) {

		String sql = "SELECT id, name, email FROM inquiry WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		model.addAttribute("title", "Inquiry From");
		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));
		return "test";
	}

}
