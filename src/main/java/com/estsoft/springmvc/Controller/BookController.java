package com.estsoft.springmvc.Controller;

import com.estsoft.springmvc.DTO.BookDTO;

import com.estsoft.springmvc.Entity.Book;
import com.estsoft.springmvc.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bs;

    public BookController(BookService bookService) {
        this.bs = bookService;
    }
    @GetMapping("/books")
    public String showAll(Model model){
        List<BookDTO> list = bs.findAll().stream().map(BookDTO::new).toList();
        model.addAttribute("bookList",list);
        return "BookManagement";
    }
    @GetMapping("/{id}")
    public String showOne(@PathVariable String id, Model model){
        Book book = bs.findBy(id);
        model.addAttribute("book",new BookDTO(book));
        return "bookDetail";
    }
    @PostMapping
    public String addBook(@RequestParam String id,@RequestParam String name,@RequestParam String author){
        bs.addBook(new Book(id,name,author));

        return "redirect:/books";//리다이렉션 -> showAll을 불러줌으로써 저장된 내역을 보여줌
    }
}
