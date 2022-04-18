package com.example.demo.service.interfaces;

import com.example.demo.model.News;
import java.util.List;
import java.util.Optional;

public interface NewsService {

    boolean create(News news);

    List<News> readAll();

    Optional<News> read(String id);

    boolean update(News news, String id);

    void delete(String id);
}
