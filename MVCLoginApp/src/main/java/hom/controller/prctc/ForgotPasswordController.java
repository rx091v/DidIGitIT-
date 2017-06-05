package hom.controller.prctc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForgotPasswordController {

	@ResponseBody
	@RequestMapping("/forgotpassword")
    public String forgotPassword() {
        return "Sorry, Ab kuch na ho paai !";
    }
	}
