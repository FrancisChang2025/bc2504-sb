package com.bootcamp.demo.demo_mtr_caller.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_mtr_caller.controller.MTROperation;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;
import com.bootcamp.demo.demo_mtr_caller.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;

  @Override
  public ABCDTO getEarliestSchedule(String stationCode) {
    return this.mtrService.getEarliestSchedule(stationCode);
  }
}
