package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.persistence.NewsRepository;
import com.example.demo.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NewsServiceImp implements NewsService {
    private final NewsRepository newsRepository;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public boolean create(News news) {
        Date date = new Date();
        Optional<News> newsIDOld = newsRepository.findById(news.getId());
        if(newsIDOld.isPresent()){
            return false;
        }
        news.setDate(simpleDateFormat.format(date));
        newsRepository.save(news);
        return true;
    }

    @Override
    public List<News> readAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> read(String ID) {
        return newsRepository.findById(ID);
    }

    @Override
    public boolean update(News news, String ID) {
        return false;
    }

    @Override
    public void delete(String ID) {
        Optional<News> news = newsRepository.findById(ID);
        news.orElseThrow(IllegalArgumentException::new);
        newsRepository.delete(news.get());
    }

}
