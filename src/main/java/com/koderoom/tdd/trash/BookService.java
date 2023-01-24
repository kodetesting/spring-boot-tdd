package com.koderoom.tdd.trash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private PagesService pagesService;

    public String getBookDetails() {
        return "Hello Book Service";
    }

    public String getBookPageDetails() {
        String pageDetails = pagesService.getPageDetails();
        return "Hello " + pageDetails ;
    }
}
