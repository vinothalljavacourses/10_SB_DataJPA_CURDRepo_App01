package com.vinothit;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vinothit.repo.BookRepository;
import com.vinothit.entity.Book;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		  ConfigurableApplicationContext ctxt=	SpringApplication.run(Application.class, args);
		  
		  BookRepository repo=ctxt.getBean(BookRepository.class);
		  
		  System.out.println(repo.getClass().getName());
		  
		  // 1. save only one Book into My SQL DB  --> To insert & Update (Insert + Update = Upsert)
		  /*Book b=new Book();
		  b.setBookId(1);
		  b.setBookName("spring");
		  b.setBookPrice(2500.00);
		  
		  repo.save(b);
		  
		  System.out.println("Record successfully inserted.....");*/
		  
		  // 2. save multiple Books into My SQL DB  --> To insert & update collection of records
		  /*Book b1=new Book();
		  b1.setBookId(3);
		  b1.setBookName("springboot");
		  b1.setBookPrice(4333.00);
		  
		  Book b2=new Book();
		  b2.setBookId(4);
		  b2.setBookName("github");
		  b2.setBookPrice(4444.00);
		  
		  Book b3=new Book();
		  b3.setBookId(5);
		  b3.setBookName("github");
		  b3.setBookPrice(5444.00);
		  
		  repo.saveAll(Arrays.asList(b1,b2,b3));
		  
		  System.out.println("All 3 Record successfully inserted with saveall.....");*/
		  
		  // 3. existsById(ID) -- To check presense of record
		  boolean existsById = repo.existsById(1);
		  System.out.println("existsById  : " + existsById);
		  
		  
		  
		  
		  
		 
		  
		  
		  
		  
	}

}
