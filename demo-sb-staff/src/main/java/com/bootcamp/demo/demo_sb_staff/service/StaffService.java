package com.bootcamp.demo.demo_sb_staff.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_sb_staff.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_staff.model.Staff;

public interface StaffService {
  StaffEntity save(Staff staff);

  Optional<StaffEntity> findById(Long id);

  List<StaffEntity> findAll();

  void deleteById(Long id);

  StaffEntity updateById(Long id, Staff staff);
}
