package com.spring.boot.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Books implements Serializable {

	private static final long serialVersionUID = -82439648328404424L;
	
	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "bk_id")
	private Long bk_id;
	
	@Column(name = "bk_title")
	private String bk_title;
	
	@Column(name = "author_name")
	private String author_name;
	
	@Column(name = "bk_publication_date")
	@Temporal(TemporalType.DATE)
	private Date bk_publication_date;
	
	@Column(name = "bk_description")
	private String bk_description;
	
	@Column(name = "bk_note")
	private String bk_note;
	
	// JSON'a dönüşütürülmesi istemediğimiz alanları bu etiketle işaretleyebiliriz
	//@JsonIgnore
	
	@OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Authors> authors;

	public void setBkId(Long bk_id) {
		this.bk_id = bk_id;
	}

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

	public List<Authors> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}

	public Long getBkId() {
		return bk_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bk_id == null) ? 0 : bk_id.hashCode());
		result = prime * result + ((author_name == null) ? 0 : author_name.hashCode());
		result = prime * result + ((bk_title == null) ? 0 : bk_title.hashCode());
		result = prime * result + ((bk_publication_date == null) ? 0 : bk_publication_date.hashCode());
		result = prime * result + ((bk_description == null) ? 0 : bk_description.hashCode());
		result = prime * result + ((bk_note == null) ? 0 : bk_note.hashCode());
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		
		if (bk_id == null) {
			if (other.bk_id != null)
				return false;
			
		} else if (!bk_id.equals(other.bk_id))
			return false;
		
		if (author_name == null) {
			if (other.author_name != null)
				return false;
		} else if (!author_name.equals(other.author_name))
			return false;
		
		if (bk_title == null) {
			if (other.bk_title != null)
				return false;
			
		} else if (!bk_title.equals(other.bk_title))
			return false;
		if (bk_publication_date == null) {
			if (other.bk_publication_date != null)
				return false;
		} else if (!bk_publication_date.equals(other.bk_publication_date))
			return false;
	
		if (bk_description == null) {
			if (other.bk_description != null)
				return false;
		} else if (!bk_description.equals(other.bk_description))
			return false;
		
		if (bk_note == null) {
			if (other.bk_note != null)
				return false;
		} else if (!bk_note.equals(other.bk_note))
			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		
		return true;
	}
}


