package com.bootcamp.demo.demo_sb_staff.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_staff.controller.StaffOperation;
import com.bootcamp.demo.demo_sb_staff.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_staff.model.Staff;
import com.bootcamp.demo.demo_sb_staff.service.StaffService;

@RestController
public class StaffControllerImpl implements StaffOperation {
  @Autowired
  private StaffService staffService;

  public StaffEntity create(Staff staff) {
    return this.staffService.save(staff);
  }

  public List<StaffEntity> getAll() {
    return this.staffService.findAll();
  }

  public StaffEntity update(Long id, Staff staff) {
    return this.staffService.updateById(id, staff);
  }

  public StaffEntity getById(Long id) {
    Optional<StaffEntity> staffEntity = this.staffService.findById(id);
    if (staffEntity.isPresent()) {
      return staffEntity.get();
    }
    return null;
  }

  public void deleteById(Long id) {
    this.staffService.deleteById(id);
  }
}
