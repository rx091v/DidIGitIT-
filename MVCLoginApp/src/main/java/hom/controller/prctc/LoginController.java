package hom.controller.prctc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping("/login")
	private String printAck() {
		System.out.println("Login Successful !!");
		return "successPage";
	}

}
