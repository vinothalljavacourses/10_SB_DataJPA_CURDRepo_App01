package com.vinothit;

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
		  
		  Book b=new Book();
		  b.setBookId(1);
		  b.setBookName("spring");
		  b.setBookPrice(2500.00);
		  
		  repo.save(b);
		  
		  System.out.println("Record successfully inserted.....");
		  
		  
		  
		  
	}

}
