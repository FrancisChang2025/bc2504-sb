package com.bootcamp.demo.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_forum.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  // JPA method
  List<PostEntity> findByTitle(String title);
  List<PostEntity> findByBody(String body);
  List<PostEntity> findByUserEntityId(Long userId); // ! For FK
}
