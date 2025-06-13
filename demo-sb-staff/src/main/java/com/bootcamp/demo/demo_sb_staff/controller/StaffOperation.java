package com.bootcamp.demo.demo_sb_staff.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_staff.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_staff.model.Staff;

public interface StaffOperation {
  @PostMapping(value = "/staff")
  public StaffEntity create(@RequestBody Staff staff);

  @GetMapping(value = "/staffs")
  public List<StaffEntity> getAll();

  @PutMapping(value = "/staff/{id}")
  public StaffEntity update(@PathVariable Long id, @RequestBody Staff staff);

  @GetMapping(value = "/staff/{id}")
  public StaffEntity getById(@PathVariable Long id);

  @DeleteMapping(value = "/staff/{id}")
  public void deleteById(@PathVariable Long id);
}
