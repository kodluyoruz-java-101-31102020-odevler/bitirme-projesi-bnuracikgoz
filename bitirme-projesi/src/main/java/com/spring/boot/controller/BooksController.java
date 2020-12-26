package com.spring.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.entity.Books;
import com.spring.boot.service.BooksService;
import com.spring.boot.service.model.BooksContext;


// Controller Layer (Rest Webservice Endpoints)
@RestController
@RequestMapping("/library")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@RequestMapping(value = "/books/{bk_id}", method = RequestMethod.GET)
	public Books findByBkId(@PathVariable("bk_id") Long bk_id) {
		
		return booksService.findWithBkId(bk_id);
	}
	
	@RequestMapping(value = "/books/list", method = RequestMethod.GET)
	public List<Books> getAllBooksList() {
		
		return booksService.getAllBooksList();
	}
	
	@RequestMapping(value = "/books/search", method = RequestMethod.POST)
	public  List<Books> searchBooksList(@RequestBody BooksContext booksContext) {
			
		return booksService.searchBooksList(booksContext);
	}
		
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public Long save(@RequestBody BooksContext booksContext) {
			
		return booksService.save(booksContext);
	}
		
	@RequestMapping(value = "/books", method = RequestMethod.PUT)
	public Long update(@RequestBody BooksContext booksContext) {
		
		return booksService.update(booksContext);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long id) {
		
		return booksService.delete(id);
	
	}
	
}
