package com.bootcamp.demo.demo_sb_staff.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_staff.entity.StaffEntity;
import com.bootcamp.demo.demo_sb_staff.model.Staff;
import com.bootcamp.demo.demo_sb_staff.repository.StaffRepository;
import com.bootcamp.demo.demo_sb_staff.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
  @Autowired
  private StaffRepository staffRepository;

  @Override
  public StaffEntity save(Staff staff) {
    StaffEntity staffEntity = new StaffEntity(staff.getId(), staff.getName(), staff.getAge());
    return staffRepository.save(staffEntity);
  }

  @Override
  public Optional<StaffEntity> findById(Long id) {
    return this.staffRepository.findById(id);
  }

  @Override
  public List<StaffEntity> findAll() {
    return this.staffRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    this.staffRepository.deleteById(id);
  }

  // PUT
  @Override
  public StaffEntity updateById(Long id, Staff staff) {
   if (this.staffRepository.findById(id).isPresent()) {
    StaffEntity staffEntity = new StaffEntity(staff.getId(), staff.getName(), staff.getAge());
    return this.staffRepository.save(staffEntity);
  }
  return null;
 }
}
