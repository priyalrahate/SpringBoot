package com.aliboucoding.jpa;

import com.aliboucoding.jpa.model.Author;
import com.aliboucoding.jpa.model.Video;
import com.aliboucoding.jpa.repositories.AuthorRepository;
import com.aliboucoding.jpa.repositories.VideoRepository;
import com.aliboucoding.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	// here we are testing whether our repository interface is working or not
	 @Bean
	public CommandLineRunner commandLineRunner
	(
       AuthorRepository repository,
	   VideoRepository videoRepository,
	   DataSourceTransactionManager dataSourceTransactionManager) {
       return args -> {
		   for(int i=0;i<50;i++) {
			   Faker faker = new Faker();
			   var author = Author.builder()
					   .firstname(faker.name().firstName())
					   .lastname(faker.name().lastName())
					   .age(faker.number().numberBetween(19,50))
					   .email("alibou"+i+"@gmail.com")
					   .build();
			   repository.save(author);
		   }
		  /* var video = Video.builder()
				   .name("abc")
				   .length(5)
				   .build();
		   videoRepository.save(video);*/


		   // update author with ID=1
		   var author = Author.builder()
				   .id(1) // note id should  be present in the table otherwise it will insert it
				   .firstname("Ali")
				   .lastname("bouli")
				   .age(34)
				   .email("alibou@gmail.com")
				   .build();
//		   repository.save(author);

		   // update Author a set a.age= 22 where a.id = 1;
//		   repository.updateAuthor(22,1);


//		    update age to 99
//		   repository.updateAge(99);
//
		   // find by name query

//		   repository.findByNameQuery(60)
//				  .forEach(System.out::println);

		   // update with name query

//		   repository.updateByNameQuery(12);


		   Specification<Author> spec = Specification
				   .where(AuthorSpecification.hasAge(34))
				   .and(AuthorSpecification.firstnameLike("Mi"));
		   repository.findAll().forEach(System.out::println);
	   };
	}

}
