package com.victorp.controller;

import com.victorp.model.User;
import com.victorp.service.SecurityService;
import com.victorp.service.UserService;
import com.victorp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/registration")
    public String registrationClient(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @GetMapping("/registrationAdmin")
    public String registrationAdmin(Model model) {
        model.addAttribute("userForm", new User());

        return "registrationAdmin";
    }
    @GetMapping("/registrationTrainers")
    public String registrationTrainers(Model model) {
        model.addAttribute("userForm", new User());

        return "registrationTrainers";
    }

    @PostMapping("/registration")
    public String addClient(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) throws Exception {

        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userService.saveClient(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "login";
        }

        userService.create(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }
    @PostMapping("/registrationTrainers")
    public String addTrainer(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) throws Exception {

        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registrationTrainers";
        }

        if (!userService.saveTrainer(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registrationTrainers";
        }

        userService.create(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }

    @PostMapping("/registrationAdmin")
    public String addAdmin(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) throws Exception {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registrationAdmin";
        }
        if (!userService.saveAdmin(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registrationAdmin";
        }

        userService.create(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/";
    }


}