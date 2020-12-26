package com.spring.boot.service;
import java.util.List;

import com.spring.boot.dao.entity.Books;
import com.spring.boot.service.model.BooksContext;


public interface IBooksService {
	
	public Books findWithBkId(Long bk_id);
	public List<Books> searchBooksList(BooksContext booksContext);
	public List<Books> getAllBooksList();
	public Long save(BooksContext booksContext);
	public Long update(BooksContext booksContext);
	public Long delete(Long bk_id);
//getle search değerini alıp listle döndürücem atıcam
}
