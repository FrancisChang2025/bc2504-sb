package com.bootcamp.demo.demo_sb_person;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public class Database {
  public static List<Integer> integers = new ArrayList<>();
  public static List<Person> persons = new ArrayList<>();

  public static boolean add(Integer integer) {
    return integers.add(integer);
  }

    @GetMapping(value = "/integer/{idx}")
   public static Integer get(Integer index) {
       return integers.get(index);
   }

   public static boolean add(Long id, String name, Integer age) {
    return persons.add(new Person(id, name, age));
   }
 
}
