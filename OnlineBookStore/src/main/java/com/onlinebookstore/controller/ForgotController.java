package com.onlinebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class ForgotController {

    Random random = new Random(1000);

    @RequestMapping("/forgot")
    public String openEmailForm(){
        return "forgot_email_form";
    }

    @PostMapping("/sendOtp")
    public String sendOTP(@RequestParam("email")String email){
        System.out.println("Email"+email);

        int otp= random.nextInt(9999);

        System.out.println("Otp"+otp);

        return "verify_otp";

    }


}
