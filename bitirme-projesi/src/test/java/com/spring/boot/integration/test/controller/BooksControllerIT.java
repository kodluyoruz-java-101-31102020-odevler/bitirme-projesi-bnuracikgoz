package com.spring.boot.integration.test.controller;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.spring.boot.dao.entity.Books;
import com.spring.boot.service.model.BooksContext;

@RunWith(SpringRunner.class)
//Web service integration test usage with random port! You have to set this setting!
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BooksControllerIT {
	@Autowired
    private TestRestTemplate restTemplate;

	@LocalServerPort
	private int tomcatPortNo;
	
	@Test
	@Order(1)
	public void testRestTemplate() {
		
		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);
		
		System.out.println(tomcatPortNo);
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}
	
	@Test
	@Order(2)
	public void findBooksById() {
		
		String url = prepareBooksRestServiceRootUrl() + "books/10003";
		
		ResponseEntity<Books> response = restTemplate.getForEntity(url, Books.class);
		
		Books emp = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(10003 == emp.getBkId());
	}
	
	@Test
	@Order(3)
	public void saveBooks() {
		
		String url = prepareBooksRestServiceRootUrl() + "books";
		
		BooksContext booksContext = new BooksContext();
		booksContext.setBkTitle("TestUser1");
		booksContext.setAuthorName("Halide Edip Adıvar");
		booksContext.setBkPublicationDate(new Date());
		booksContext.setBkDescription("testUser1");
		booksContext.setBkNote("F");

		ResponseEntity<Long> response = restTemplate.postForEntity(url, booksContext, Long.class);
		
		Long bk_id = response.getBody();
		
		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(bk_id);
	}
	
	
	private String prepareBooksRestServiceRootUrl() {
		
		return "http://localhost:" + tomcatPortNo + "/company/";
	}
}
