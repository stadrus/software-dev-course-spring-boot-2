package com.example.mycollections.controllers;


import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("The Matrix", "Wachowskis", 1999, 150));
        add(new Movie("The Lion King", "Rogers Allers", 1994, 90));
        add(new Movie("Titanic", "James Cameron", 1997, 120));
    }};

    @GetMapping("/json")
    public List<Movie> getMovieJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMovieHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + movie.getDirector()+ movie.getYear()+ movie.getRuntime() +"</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movie</h1>
                        <ul>
                """ +
                movieList +
                """
                         </ul>
                    </body>
                </html>
                """;

    }
}