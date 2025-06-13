package com.bootcamp.demo.bc_forum.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_forum.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // JPA Methods
  List<UserEntity> findByZipcode(String zipcode);
  // select * from users where zipcode = ?

  Optional<UserEntity> findByCity(String city);

  // UserEntity
}
