package com.example.mycollections.controllers;


import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final List<Movie> movie = new ArrayList<>() {{
        add(new Movie("Ordinary", "Alex Warren", 2025, 60));
        add(new Movie("Just in case", "Morgan Wallen", 2025, 90));
        add(new Movie("Luther", "Kendrick Lamar & SZA", 205, 120));
    }};

    @GetMapping("/json")
    public List<Movie> getMovieJson() {
        return movie;
    }

    @GetMapping("/html")
    public String getMovieHtml() {
        String movieList = "<ul>";
        for (Movie movie : movie) {
            movieList += "<li>" + movie + "</li>";
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
                        """;

    }
}