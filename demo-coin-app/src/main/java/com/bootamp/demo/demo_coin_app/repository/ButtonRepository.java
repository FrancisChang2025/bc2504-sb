package com.bootamp.demo.demo_coin_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;

@Repository
public interface ButtonRepository extends JpaRepository<ButtonEntity, Long>{
  
}
