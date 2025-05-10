package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author,Integer> {

    // named query implementation frm author
    @Transactional
    List<Author> findByNameQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNameQuery(@Param("age") int age);

    // update Author a set a.age= 22 where a.id = 1;
     @Modifying  // hybernate will know that this is the update query;
     @Transactional
    @Query("update Author a set a.age=22 where a.id= :id")
    int updateAuthor(int age, int id);

     // update age

    @Modifying
    @Transactional
    @Query("update Author a set a.age=99")
    int updateAge(int age);







        //select * from author where firstname=' '

    List<Author> findAllByFirstname(String fn);

    List<Author> findAllByFirstnameIgnoreCase(String fn);

    //select * from firstname where first_name like '%al%'
    List<Author> findAllByFirstnameContainingIgnoreCase(String fn);

    // select * from author where firstname like 'al%'
    List<Author> findAllByFirstnameStartingWithIgnoreCase(String fn);

    // select * from author where firstname like '%al'
    List<Author> findAllByFirstnameEndingWithIgnoreCase(String fn);

    //Select * from author where firstname in ('ali','bou','coding')

    List<Author> findAllByFirstnameInIgnoreCase(List<String> fn);



}
