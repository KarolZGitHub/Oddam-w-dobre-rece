package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute(new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String processUserRegister(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/register";
        }
        if (!userService.saveUser(user)) {
            return "redirect:/register";
        } else {
            return "redirect:/";
        }
    }
}
