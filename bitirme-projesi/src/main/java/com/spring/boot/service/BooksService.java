package com.spring.boot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.boot.dao.entity.Books;
import com.spring.boot.dao.jpa.repository.BooksRepository;
import com.spring.boot.service.model.BooksContext;

//Business Layer
@Service
public class BooksService implements IBooksService{
	
	@Autowired
	private BooksRepository booksRepository;
	
	public Books findWithBkId(Long bk_id) {
		return booksRepository.findWithBkId(bk_id);
	}
	
	
	public List<Books> getAllBooksList() {
		
		return booksRepository.getAllBooksList();
	}


	public List<Books> searchBooksList(BooksContext booksContext) {
	
		
		return booksRepository.searchBooksList(booksContext.getBkTitle());
		/*
		if(books.getBkId() > 0) {
			throw new RuntimeException("CUSTOM ERROR FOR ROLLBACK!");
		}
		*/
		
	}
	
	@Transactional
	public Long save(BooksContext booksContext) {
		
		Long maxId = booksRepository.findMaxId() + 1;
		
		Books books= new Books();
		books.setBkId(maxId);
		books.setBkTitle(booksContext.getBkTitle());
		books.setAuthorName(booksContext.getAuthorName());
		books.setBkPublicationDate(booksContext.getBkPublicationDate());
		books.setBkDescription(booksContext.getBkDescription());
		books.setBkNote(booksContext.getBkNote());
		books = booksRepository.save(books);
		/*
		if(books.getBkId() > 0) {
			throw new RuntimeException("CUSTOM ERROR FOR ROLLBACK!");
		}
		*/
		return books.getBkId();
	}
	
	@Transactional
	public Long update(BooksContext booksContext) {
		
		Books books = booksRepository.findWithBkId(booksContext.getBkId());
		if(books == null)
		{
			throw new RuntimeException(booksContext.getBkId() + " ID not found in DB!");
		}
		
		books.setBkTitle(booksContext.getBkTitle());
		books.setBkPublicationDate(booksContext.getBkPublicationDate());
		books.setBkDescription(booksContext.getBkDescription());
		books.setBkNote(booksContext.getBkNote());
		
		booksRepository.save(books);
		return books.getBkId();
	}
	
	@Transactional
	public Long delete(Long bk_id) {
		
		booksRepository.deleteAll();
		return bk_id;
	}

}
