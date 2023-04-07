package com.vinothit;

import java.util.Arrays;
import java.util.List;
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
		  
		 /*       ======================
				  CrudRepository Methods
				  =======================
				  1) save(E) : To insert & Update ( Insert + Update = Upsert )
				  2) saveAll(Iterable) : To insert & update collection of records
				  3) boolean existsById(ID) : To check presense of record (true/false)
				  4) count ( ) : To get records count in table
				  5) findById(ID) : To retrieve record based on given PK
				  6) findAllById(Iterable ids): Retrieve records based on given PKs
				  7) findAll () : To retrieve all records from table
				  8) deleteById(ID) : Delete record based on given PK
				  9) deleteAllById (Iterable ids): Delete records based on given PKs
				  10) delete(E) : Delete record based on given Entity obj
				  11) deleteAll(Iterable entities): Delete records based on given Entity objs
				  12) deleteAll ( ) : Delete all records from table (truncate)
		  */
		  
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
		  
		  
		  // 8) deleteById(ID) : Delete record based on given PK
		  if(repo.existsById(50)){
		     repo.deleteById(50);
		  }else {
			  System.out.println("No Record Found for this ID");
		  }
		  
		  // 9) deleteAllById (Iterable ids): Delete records based on given PKs
		  //repo.deleteAllById(Arrays.asList(3,4));
		  
		  //10) delete(E) : Delete record based on given Entity obj
		  
		  //11) deleteAll(Iterable entities): Delete records based on given Entity objs
		  
		  //12) deleteAll ( ) : Delete all records from table (truncate)
		  
		  
		  //Requirement : Retrieve books whose price is >=2700
		  
		  
		  // FIND BY METHODS - EXAMPLE
		  // Requirement - Find Records who's Book Price is > 2500
		  List<Book> findByBookPriceGreaterThan = repo.findByBookPriceGreaterThan(2500.00);
		  for(Book b : findByBookPriceGreaterThan) {
			  System.out.println("findByBookPriceGreaterThan :: " + b);
		  }
		  
		  
		  // Requirement - Find Records who's Book Price is <= 2500
		  List<Book> findByBookPriceLessThanEqual = repo.findByBookPriceLessThanEqual(2500.00);
		  for(Book b : findByBookPriceLessThanEqual) {
			  System.out.println("findByBookPriceLessThanEqual  :: " + b);
		  }
			  
		  // Requirement - Find Records who's Book Price is < 2500 
		 List<Book> findByBookPriceLessThan = repo.findByBookPriceLessThan(2500.00);
		 for(Book b : findByBookPriceLessThan) {
			 System.out.println("findByBookPriceLessThan  :: " + b);
		 }

		 
		 // Requirement - Find Records who's Book Name is GitHub [Not Case Sensitive]
		 List<Book> findByBookName = repo.findByBookName("GitHub");
		 for(Book b : findByBookName) {
			 System.out.println("findByBookName  :: " + b);
		 }

		 List<Book> findByBookNameStartingWith = repo.findByBookNameStartingWith("Sp");
		 for(Book b : findByBookNameStartingWith) {
			 System.out.println("findByBookNameStartingWith  :: " + findByBookNameStartingWith );
		 }
		 
		 
		 //Custom Queries - 1. Native SQL Query Example...
		 List<Book> getAllBooks = repo.getAllBooks();
		 for(Book b : getAllBooks) {
			 System.out.println("getAllBooks - Native SQL Query Example :: " + b);
		 }
		 
		//Custom Queries - 2. HQL Query Example...
		 List<Book> books = repo.getBooks();
		 for(Book b : books) {
			 System.out.println("Books  -  HQL Query Example :: " + b);
		 }
		 
	}

}
