package controller;

import javax.validation.Valid;

import model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {


    @Autowired
    Repository.userRepository userRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
       // registry.addViewController("/loginForm").setViewName("loginForm");
    }

    @GetMapping(value = "/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping(value = "/")
    public String checkPersonInfo(
            @RequestParam("name") String fName,
            @RequestParam("lastname") String lName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("repassword") String repeatPassword,
            @Valid PersonForm user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        if (!bindingResult.hasErrors()) {

            user.setEmail(email);
            boolean getEmail = userRepository.checkEmail(user);
            if (getEmail) {

                return "form";
            }
            user.setID(0);
            user.setName(fName);
            user.setLastname(lName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRepassword(repeatPassword);
            boolean usr = userRepository.createAccount(user);

            if (usr) {
                return "redirect:/results";
            }
        }
        return "redirect:/results";

    }
}