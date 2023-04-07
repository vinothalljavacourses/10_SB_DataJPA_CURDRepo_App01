package com.vinothit.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Book {

	@Id
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
	
	
	
}
