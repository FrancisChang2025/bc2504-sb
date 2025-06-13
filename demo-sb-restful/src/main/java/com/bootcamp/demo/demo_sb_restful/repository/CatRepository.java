package com.bootcamp.demo.demo_sb_restful.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;

// ! Spring boot 3
@Repository
public interface CatRepository extends JpaRepository<CatEntity, Long> {
  // select * from cats where name = ?

  // !JPA Query Method
  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  List<CatEntity> findByName(String name);
  List<CatEntity> findByAgeGreaterThanEqualOrderByNameDesc(Integer age);

  // Hibernate (JobsDB)
  // maven compile -> Hibernate helps generate a class that implements this interface

  // Hibernate generated findAll(), so that you can call findAll() directly in service layer
  // select * from cats;

  // Hibernate generated save(), so that you can call save() directly in service layer
  // insert into cats values (1L, 'John', 13");
  
}
