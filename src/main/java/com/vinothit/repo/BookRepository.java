package com.vinothit.repo;

import org.springframework.data.repository.CrudRepository;
import com.vinothit.entity.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{

}
