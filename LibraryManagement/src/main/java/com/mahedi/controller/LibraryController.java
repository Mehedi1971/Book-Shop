package com.mahedi.controller;

import com.mahedi.entity.Library;
import com.mahedi.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String allBooks(Model model){
        model.addAttribute("listofallBooks",libraryService.getAllBooks());
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("listofallBooks",libraryService.getAllBooks());
        return "dashboard";
    }

    @GetMapping("/savenew")
    public String newAdds(Model model){
        Library library=new Library();
//        model.addAttribute("newAdd",library);
        System.out.println(library);
        model.addAttribute("newAdd",library);
        return "savenew";
    }

    @PostMapping("/saveNewBooks")
    public String savenew(@ModelAttribute Library library){
//        libraryService.saveBook(library);
        libraryService.saveBook(library);
        System.out.println(library);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id,Model model)
    {
        Library library= libraryService.updateBooks(id);
        model.addAttribute("update",library);
        return "/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        libraryService.deleteBooks(id);

        return "redirect:/";
    }

}
