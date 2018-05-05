package su.nkarulin.emojmovies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dispatcher {

    @RequestMapping("/")
    String redirectFromRoot() {
        return "redirect:/movies/";
    }
}
