package su.nkarulin.emojmovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import su.nkarulin.emojmovies.domain.Movie;
import su.nkarulin.emojmovies.domain.MovieComment;
import su.nkarulin.emojmovies.repositories.MovieCommentsRepository;
import su.nkarulin.emojmovies.repositories.MovieRepository;
import su.nkarulin.emojmovies.services.ImagesStorageService;

import java.security.Principal;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    ImagesStorageService imagesStorageService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCommentsRepository movieCommentsRepository;

    @GetMapping("/management/add")
    public String addMoviePage() {
        return "uploadMoview";
    }

    @PostMapping("/management")
    public String addMovie(@RequestParam("title") String title,
                           @RequestParam("year") int year,
                           @RequestParam("imageFile") MultipartFile imageFile) {
        Movie movie = new Movie();

        movie.setImage(imagesStorageService.store(imageFile));

        movie.setTitle(title);
        movie.setYear(year);

        movieRepository.save(movie);

        return "redirect:/movies/";
    }

    @GetMapping("/")
    public String moviesList(Model model) {
        model.addAttribute("movies", movieRepository.findAll());

        return "movies";
    }

    @GetMapping("/{id}")
    public String moviePage(@PathVariable long id,
                            Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "moviePage";
    }

    @PostMapping("/{id}/comment")
    public String addNewComment(@PathVariable long id,
                                Principal principal,
                                @ModelAttribute("commentText") String commentText, Model model) {
        MovieComment movieComment = new MovieComment();
        movieComment.setText(commentText);
        movieComment.setAuthor(principal == null ? "Anon" : principal.getName());

        Movie movie = movieRepository.findById(id).get();
        
        movieComment.setMovie(movie);
        movieComment = movieCommentsRepository.save(movieComment);

        movie.getComments().add(movieComment);
        movieRepository.save(movie);

        model.addAttribute("movie", movieRepository.findById(id).get());
        
        return "redirect:/movies/" + id;
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable long id) {
        movieRepository.deleteById(id);

        return "redirect:/movies/";
    }
}
