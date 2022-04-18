package com.example.demo.controller;

import com.example.demo.model.News;
import com.example.demo.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestFullNewsController {
    private final NewsService newsService;

    @PostMapping( "v1336/create")
    public ResponseEntity<?> create(@RequestBody News news) {
        if(newsService.create(news)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("v1336/viewAll")
    public ResponseEntity<List<News>> readAll(){
        final List<News> news = newsService.readAll();

        return news != null
                    ? new ResponseEntity<>(news, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("v1336/search")
    public ResponseEntity<News> read(@RequestParam("id") String ID){
        try{
            newsService.read(ID);
            return new ResponseEntity<>(newsService.read(ID).get(), HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("v1336/{id}")
    public ResponseEntity<?> delete(@PathVariable(name ="id") String ID){
        try {
            newsService.delete(ID);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("v1336/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String ID, @RequestBody News news){
        final boolean updated = newsService.update(news, ID);

        return updated
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
