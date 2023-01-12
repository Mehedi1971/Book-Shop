package com.mahedi.controller;

import com.mahedi.entity.Library;

import com.mahedi.repository.LibraryRepository;
import com.mahedi.service.LibraryService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private LibraryRepository libraryRepository;


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
    
    @GetMapping("/bookdetails/{id}")
    public String dashboard(@PathVariable long id,Model model){
    	Library library= libraryService.getOneBook(id);
        model.addAttribute("bookdetails",library);
        return "Bookdetails";
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
	public String imageUpload(@RequestParam MultipartFile img, @ModelAttribute Library library) {
//    reportInformationService.saveReportInfo(reportInformation);
//    ReportInformation im = new ReportInformation();
//        reportInformation.setrHospitalLogo1(img.getOriginalFilename());

    	library.setImage(img.getOriginalFilename());
    	library.setBookAuthor(library.getBookAuthor());
    	library.setBookName(library.getBookName());
    	library.setDescription(library.getDescription());
    	library.setQuantity(library.getQuantity());
    	library.setPrice(library.getPrice());
    	
    	Library uploadImg = libraryRepository.save(library);

		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				// System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//    session.setAttribute("msg", "Image Upload Sucessfully");

		return "redirect:/";
	}
    
    

//    @PostMapping("/saveNewBooks")
//    public String savenew(@ModelAttribute Library library){
////        libraryService.saveBook(library);
//        libraryService.saveBook(library);
//        System.out.println(library);
//        return "redirect:/";
//    }

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
