package controller;

import model.LoginForm;
import model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    Repository.userRepository userRepository;

    @GetMapping(value = "/LoginForm")
    public String showLogin(LoginForm loginForm, Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @PostMapping(value = "/LoginForm")
    public String checkLogin(
            @RequestParam("Email") String email,
            @RequestParam("Password") String password,
            @Valid LoginForm user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }

        if (!bindingResult.hasErrors()) {
            PersonForm u = new PersonForm();
            u.setEmail(email);
            u.setPassword(password);
            boolean log = userRepository.checkLogin(u);
            if (log) {
                return "redirect:/results";
            } else {
                return "loginForm";
            }
        }
        return "redirect:/results";
    }
    //  @ModelAttribute("loginForm")

}

