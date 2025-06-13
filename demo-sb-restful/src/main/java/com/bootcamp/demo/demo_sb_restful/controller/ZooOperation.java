package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.dto.ZooReqDTO;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;

public interface ZooOperation {
  @PostMapping(value = "/zoo")
  ZooEntity create(@RequestBody ZooReqDTO dto);

  @GetMapping(value = "/zoo/id/{id}")
  ZooEntity findById(@PathVariable Long id);

  @GetMapping(value = "/zoo/name/{name}")
  List<ZooEntity> findByName(@PathVariable String name);

  /*
  @GetMapping(value = "/zoo/{id}/cats")
  List<ZooEntity> getAll();

  @GetMapping(value = "/zoo/id/{id}")
  ZooEntity getById(@PathVariable Long id, @RequestBody ZooReqDTO dto);

  @PutMapping(value = "/zoo/id/{id}/cat")
  ZooEntity update(@PathVariable Long id, @RequestBody ZooReqDTO dto);

  @DeleteMapping(value = "/zoo/id/{id}/cat")
  void deleteById(@PathVariable Long id, @RequestBody ZooReqDTO dto);
  */

}
