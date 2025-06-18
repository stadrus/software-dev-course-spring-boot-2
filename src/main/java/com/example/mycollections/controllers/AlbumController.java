package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")

public class AlbumController {
    private List<Album> albums = new ArrayList<>() {{
        add(new Album("Ordinary", "Alex Warren", 2025, 60));
        add(new Album("Just in case", "Morgan Wallen", 2025, 90));
        add(new Album("Luther", "Kendrick Lamar & SZA", 205, 120));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumHtml() {
        String albumList = "<ul>";
        for (Album album : albums ){
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Album</h1>
                        <ul>
                """ +
                albumList+
                """
                                </ul>
                            </body>
                </html>
                """;
    }
}

