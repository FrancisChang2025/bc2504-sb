package com.bootcamp.demo.demo_mtr_caller.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_mtr_caller.controller.MTROperation;
import com.bootcamp.demo.demo_mtr_caller.dto.IJKDTO;
import com.bootcamp.demo.demo_mtr_caller.dto.mapper.DTOMapper;
import com.bootcamp.demo.demo_mtr_caller.model.ApiResp;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;
import com.bootcamp.demo.demo_mtr_caller.service.MTRService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public ApiResp<IJKDTO> getEarliestSchedule(String stationCode)
        throws JsonProcessingException {
    ABCDTO abcdto = this.mtrService.getEarliestSchedule(stationCode);
    IJKDTO ijkdto = this.dtoMapper.map(abcdto);
    return ApiResp.<IJKDTO>builder() //
          .data(ijkdto) //
          .build();
  }
}
