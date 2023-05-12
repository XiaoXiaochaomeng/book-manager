package com.example.bookmanagment.controller;

import com.example.bookmanagment.entity.Book;
import com.example.bookmanagment.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @RequestMapping("/")
    public String index(@RequestParam(value = "id",required = false,defaultValue = "")String id, Model model){
        Book formModel = Book.builder().build();

        if(!id.isEmpty()){
            formModel = bookService.getBookById(Integer.parseInt(id));
        }
        model.addAttribute( "bookForm",formModel);
        model.addAttribute("listBook",bookService.getListOfBook());
        return "index";
    }
    @RequestMapping("/save")
    @PostMapping
    public String save(@ModelAttribute("bookForm")Book bookInfo,Model model){
        bookService.insertNewBook(bookInfo);

        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id",required = false,defaultValue = "")String id,Model model){
        if(!id.isEmpty()){
            bookService.deleteById(Integer.parseInt(id));
        }
        return "redirect:/";
    }
}
