package com.estsoft.springmvc.Service;

import com.estsoft.springmvc.Entity.Book;
import com.estsoft.springmvc.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service//책생성 BookService, 조회 BookService, 단건 조회 BookService
public class BookService {
    private BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> findAll() {
        return repo.findAll(Sort.by("id"));//오름차순
    }

    public Book findBy(@PathVariable String id){
        return repo.findById(id).orElse(new Book());
    }
    public Book addBook(Book book){
        return repo.save(book);
    }
}
