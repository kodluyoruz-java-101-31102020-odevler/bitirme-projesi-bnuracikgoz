package com.spring.boot.integration.test.dao.jpa;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.entity.Books;
import com.spring.boot.dao.jpa.repository.BooksRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BooksRepositoryIT {
	
	@Autowired
	private BooksRepository boooksRepository;
	
	
	@Test
	@Order(1)
	public void selectBooksByBkId() {
		
		Long maxId = boooksRepository.findMaxId();
		Books books = boooksRepository.findWithBkId(maxId);
		
		Assert.assertNotNull(books);
		Assert.assertTrue(books.getBkId() > 0);
	}
	
/*	@Test
	@Order(2)
	public void selectAllBooksProfileList() {
		
		List<BooksProfile> booksProfileList = booksRepository.getAllBooksProfileList(PageRequest.of(0, 1));
		
		Assert.assertEquals(booksProfileList.size(), 1);
	}*/
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(3)
	public void saveBooks() {
		
		Long maxId = boooksRepository.findMaxId();
		Long newBooksBkId = maxId + 1;
		
		Books books = new Books();
		books.setBkId(newBooksBkId );
		books.setBkTitle("Ahmet");
		books.setAuthorName("Mehmet");
		books.setBkDescription("Mdfg");
		books.setBkPublicationDate(new Date());
		books.setBkNote("M");
		boooksRepository.save(books);
		
		books = boooksRepository.findWithBkId(newBooksBkId);
		
		Assert.assertNotNull(books);
		Assert.assertTrue(books.getBkId() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(4)
	public void updateBooks() {
		
		Long maxId = boooksRepository.findMaxId();
		Books boooks = boooksRepository.findWithBkId(maxId);
		
		boooks.setAuthorName("Ayşe");
		boooks.setBkDescription("Hürel");
		boooks.setBkNote("M");
		
		boooksRepository.save(boooks);
		
		boooks = boooksRepository.findWithBkId(maxId);
		
		Assert.assertEquals("Ayşe", boooks.getAuthorName());
		Assert.assertEquals("Hürel", boooks.getBkDescription());
		Assert.assertEquals("M", boooks.getBkNote());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(5)
	public void deleteBooks() {
		
		Long maxId = boooksRepository.findMaxId();
		Books boooks = boooksRepository.findWithBkId(maxId);
		
		boooksRepository.delete(boooks);
		
		boooks = boooksRepository.findWithBkId(maxId);
		
		Assert.assertNull(boooks);
	}
}
