package com.vinothit;

import java.util.Arrays;
import java.util.Optional;

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
		  
		  System.out.println("All 3 Record successfully inserted with safely.....");*/
		  
		  // 3. existsById(ID) -- To check presence of record (true/false) value.
		  boolean existsById = repo.existsById(1);
		  System.out.println("Record Presence  : " + existsById);
		  
		  // 4. count() : To get records count in table
		  long count = repo.count();
		  System.out.println("Records Count : " + count);
		  
		  // 5. findById(ID) : To retrieve record based on given single PK(Primary Key)
		  Optional<Book> findById = repo.findById(1);
		  System.out.println("findById  : " + findById);
		  
		  if(findById.isPresent()) {
			  System.out.println("findById  isPresent : " + findById);
			  System.out.println("findById.get()  isPresent : " + findById.get());
		  }
		  
		  // 6. findAllById(Iterable ids) : To retrieve record based on given all PKs(Primary Key) with comma separator
		  Iterable<Book> findAllById = repo.findAllById(Arrays.asList(1,2,3));
		  System.out.println("findAllById : "+ findAllById);
		  for(Book b : findAllById) {
			  System.out.println("B  findAllById : " + b);
		  }
		  
		  // 7. findAll() : To Retrieve all records from table.
		  Iterable<Book> findAll = repo.findAll();
		  for(Book b : findAll) {
			  System.out.println("b findAll " + b);
		  }
		  
		  
		  
	}

}
