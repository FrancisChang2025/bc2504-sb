package com.bootcamp.gov.data.demo_gov_data.repository;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.gov.data.demo_gov_data.entity.WeatherEntity;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
  // 1. JPA Method
  Optional<WeatherEntity> findByDate(LocalDate date);

  // ! 2. JPQL: similar to SQL, select Entity class
  @Query("select e from WeatherEntity e where e.date = :date")
  Optional<WeatherEntity> getWeatherJPQL(@Param(value = "date") LocalDate date);

  // ! 3. Query (SQL) -> What are the disadvantages?
  // - SQL syntax is per Database Product (Postgres, but Oracle not okay)
  @Query(value = "select e.id, e.date, e.max_temp, e.min_temp, e.max_rh, e.min_rh from weathers e where e.date = :date",
      nativeQuery = true)
  Optional<WeatherEntity> getWeatherSQL(@Param(value = "date") LocalDate date);
}
