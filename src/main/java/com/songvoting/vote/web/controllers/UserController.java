package com.songvoting.vote.web.controllers;

import com.songvoting.vote.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String template(Model model) {
        model.addAttribute("title", "בחירת שיר החופה!");
        model.addAttribute("subtitle", "(לא לדאוג, אנחנו לא נתקשר...)");
        return "login";
    }

    @GetMapping("/alreadyVoted")
    public String alreadyVotedTemplate(Model model) {
        model.addAttribute("message", "כבר הצבעתם, עופו להרים לנו!");
        return "voted";
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestBody MultiValueMap<String, String> formData, ModelMap model) {
        if (userService.register(formData.getFirst("phoneNumber"))) {
            return new ModelAndView("redirect:/votes", model);
        } else {
            return new ModelAndView("redirect:/alreadyVoted", model);
        }
    }
}
