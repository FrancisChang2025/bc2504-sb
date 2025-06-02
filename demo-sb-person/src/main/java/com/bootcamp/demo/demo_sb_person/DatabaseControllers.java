package com.bootcamp.demo.demo_sb_person;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@ResponseBody
public class DatabaseControllers {
  // ! RESTful API -> design for identifying a resource
  // In this case, resource =->intergers 
  // create a new resource
  @PostMapping(value = "/integer/{x}")
   public boolean addInteger(@PathVariable Integer x) {
    return Database.add(x);
   }

   // get integer by index
   @GetMapping(value = "/integer/{idx}")
   public Integer GetInteger(@PathVariable Integer idx) {
    return Database.get(idx);
   }

   @GetMapping("/integers")
   public List<Integer> getIntegers() {
    return Database.integers;
   }

   // 1. POST Person to database
   // RequesParam String (name) Integer (age)
   @PostMapping(value = "/person1")
   public Person createPerson(@RequestParam(value = "x") String name,
      @RequestParam(value = "y") Integer age) {
    Person newPerson = new Person(1L, name, age);
      if (Database.persons.add(newPerson))
        return newPerson;
      return null;
     }

   // 2. Get all persons
   @GetMapping(value = "/persons1")
   public List<Person> getAllPersons() {
    return Database.persons;
   }

   // 3. Get Person by name (stream -> filter -> findany)
   @GetMapping("/person1/name/{name}")
   public Person getPerson(@PathVariable String name) {
    Optional<Person> result = Database.persons.stream()
      .filter(e -> e.getName().equals(name)).findAny();
    return result.isPresent() ? result.get() : null;
   }

   // ! Update the resource (replace the whole resource by a new resource)
   @PutMapping(value = "/person1/id/{id}")
   public Person updatePerson(@RequestBody Person newPerson) {
    for(int i = 0; i < Database.persons.size(); i++){
      if (Database.persons.get(i).getId() == newPerson.getId()) {
        Database.persons.set(i, newPerson);
        return newPerson;
      }
    }
    return null;
   }
  }
