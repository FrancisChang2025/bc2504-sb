package com.bootcamp.demo.demo_mtr_caller.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_mtr_caller.dto.IJKDTO;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;

@Component
public class DTOMapper {
  public IJKDTO map(ABCDTO abcdto) {
    List<IJKDTO.Train> trains = abcdto.getTrains().stream() //
      .map(e -> IJKDTO.Train.builder() //
        .destination(e.getDestination()) //
        .arrivalTime(e.getArrivalTime()) //
        .direction(e.getDirection()) //
        .build()) //
      .collect(Collectors.toList());

    return IJKDTO.builder() //
      .trains(trains) //
      .currTime(abcdto.getCurrTime()) //
      .sysTime(abcdto.getSysTime()) //
      .currentStation(abcdto.getCurrentStation()) //
      .build();
  }
}
