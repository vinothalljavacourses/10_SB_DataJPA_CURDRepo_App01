package com.vinothit.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Book {

	@Id
	private Integer BookId;
	private String BookName;
	private Double BookPrice;
	
	
	
}
