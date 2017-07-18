package web.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "test")
public class TestC
{
	@RequestMapping(value = "test")
	@ResponseBody
	public String test(){

		return "w success";
	}
}
 