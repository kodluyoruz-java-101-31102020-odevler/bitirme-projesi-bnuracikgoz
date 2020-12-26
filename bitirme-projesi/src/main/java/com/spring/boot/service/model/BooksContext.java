package com.spring.boot.service.model;

import java.io.Serializable;
import java.util.Date;

public class BooksContext  implements Serializable {

	private static final long serialVersionUID = 3906169278470348749L;
	
	private Long bk_id;
	private String bk_title;
	private String author_name;
	private Date bk_publication_date;
	private String bk_description;
	private String bk_note;

	public String getBkTitle() {
		return bk_title;
	}

	public void setBkTitle(String bk_title) {
		this.bk_title = bk_title;
	}

	public String getAuthorName() {
		return author_name;
	}

	public void setAuthorName(String author_name) {
		this.author_name = author_name;
	}

	public Date getBkPublicationDate() {
		return bk_publication_date;
	}

	public void setBkPublicationDate(Date bk_publication_date) {
		this.bk_publication_date = bk_publication_date;
	}

	public String getBkDescription() {
		return bk_description;
	}

	public void setBkDescription(String bk_description) {
		this.bk_description = bk_description;
	}

	public String getBkNote() {
		return bk_note;
	}

	public void setBkNote(String bk_note) {
		this.bk_note = bk_note;
	}
	public Long getBkId() {
		return bk_id;
	}

	public void setBkId(Long bk_id) {
		this.bk_id = bk_id;
	}

}
