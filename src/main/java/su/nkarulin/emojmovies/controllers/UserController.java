package su.nkarulin.emojmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import su.nkarulin.emojmovies.domain.EmojMoviesUser;
import su.nkarulin.emojmovies.repositories.EmojMoviesUserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    EmojMoviesUserRepository emojMoviesUserRepository;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/registration")
    String registrationPage(Model model) {
        EmojMoviesUser user = new EmojMoviesUser();
        user.setLogin("User123455");
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/")
    String registerNewUser(@ModelAttribute("user") EmojMoviesUser user, Model model) {
        if (emojMoviesUserRepository.findById(user.getLogin()).isPresent()) {
            model.addAttribute("errorMessage", "User already exists");
            return "registration";
        }

        emojMoviesUserRepository.save(user);
        user.setPassword("");
        model.addAttribute("infoMessage", "You have successfully registered");

        return "login";
    }
}
