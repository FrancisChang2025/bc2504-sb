package com.bootcamp.demo.demo_sb_restful.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;

@Repository
public interface ZooRepository extends JpaRepository<ZooEntity, Long> {
  List<ZooEntity> findByName(String zooName);
}
