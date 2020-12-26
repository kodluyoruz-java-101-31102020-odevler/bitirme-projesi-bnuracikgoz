package com.spring.boot.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Authors implements Serializable{
	
	private static final long serialVersionUID = -82439648328404424L;
	
	@Id
	@org.springframework.data.annotation.Id
	
	@Column(name = "author_id")
	private Long author_id;
	
	@Column(name = "author_name")
	private String author_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_name", insertable = false, updatable = false)
	private Books books;
	
	public Long getAuthorId() {
		return author_id;
	}

	public void setAuthorId(Long author_id) {
		this.author_id = author_id;
	}

	public String getAuthorName() {
		return author_name;
	}

	public void setAuthorName(String author_name) {
		this.author_name = author_name;
	}
	public Books getBooks() {
		return books;
	}
	
	public void setBooks(Books books) {
		this.books = books;
	}


}
