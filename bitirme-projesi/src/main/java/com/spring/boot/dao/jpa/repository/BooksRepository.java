package com.spring.boot.dao.jpa.repository;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.boot.dao.entity.Books;


// Data Layer
@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {

	@Query(value = "SELECT b FROM Books b WHERE b.bk_id = :bk_id")
	public Books findWithBkId(@Param("bk_id") Long bk_id);
	
	@Query(value = "SELECT * FROM books b WHERE b.bk_title like '%bk_title%'", nativeQuery = true)
	//public Books findWithBkTitle(@Param("bk_title") String bk_title);
	public List<Books> searchBooksList(@Param("bk_title") String bk_title );
	
	@Query(value = "SELECT MAX(b.bk_id) FROM Books b")
	public Long findMaxId();
	
	@Query(value = "SELECT b FROM Books b ")
	public List<Books> getAllBooksList();
		

}
