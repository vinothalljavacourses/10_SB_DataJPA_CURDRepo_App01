package com.vinothit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.vinothit.entity.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
	
	//FindBy Methods for Non Primary Keys Examples
	
	// select * from book where book_price  > : bookPrice
	public List<Book> findByBookPriceGreaterThan(Double bookPrice);
	
	// select * from book where book_price <= : bookPrice
	public List<Book> findByBookPriceLessThanEqual(Double bookPrice);
	
	// select * from book where book_price < : bookPrice
	public List<Book> findByBookPriceLessThan(Double bookPrice);
	
	// select * from book where book_name < : bookName
	public List<Book> findByBookName(String bookName);
	
	public List<Book> findByBookNameStartingWith(String bookName);
	
   //Custom Queries - 1. Native SQL Query...
   @Query(value= "select * from Book" , nativeQuery = true)
   public List<Book> getAllBooks(); 
   
   //Custom Queries - 2. HQL Query...
   @Query("from Book")
   public List<Book> getBooks();
	

}
