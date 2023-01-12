package com.mahedi.service;

import com.mahedi.entity.Library;
import com.mahedi.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllBooks(){
        return libraryRepository.findAll();
    }

//    public void saveBook(Library library){
//        this.libraryRepository.save(library);
//    }

    public Library getOneBook(long id) {
    	Optional<Library> optional= libraryRepository.findById(id);
    	Library library=optional.get();
    	return library;
    }
    public Library updateBooks(long id){
        Optional<Library> optional=libraryRepository.findById(id);
        Library library=optional.get();

        return library;
    }


    public void deleteBooks(long id){
        this.libraryRepository.deleteById(id);
    }


}
