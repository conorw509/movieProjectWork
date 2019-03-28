package controller;

import model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
       // registry.addViewController("/loginForm").setViewName("loginForm");
    }


    @GetMapping(value = "/LoginForm")
    public String showLogin(LoginForm loginForm, Model model) {
         model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @PostMapping(value = "/LoginForm")
    public String checkLogin(
            @Valid LoginForm user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }
        return "redirect:/results";
    }
    //  @ModelAttribute("loginForm")

}

