package uz.mohirdev.web.rest;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentResource {
    @GetMapping("/students")
    public ResponseEntity hello(){
        return ResponseEntity.ok("Hello world mohirdev");
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PostMapping("student/list")
    public ResponseEntity createAll(@RequestBody List<Student> students){
        return ResponseEntity.ok(students);
    }

    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student();
        student.setId(id);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/students/all")
    public ResponseEntity getAll(@RequestParam Long id, @RequestParam String name, @RequestParam String lastName, @RequestParam Integer age){
        List<Student> students = new ArrayList<>();
        students.add(new Student(id, name, lastName, age));
        students.add(new Student(11l, "Shohrux", "Shoh", 24));
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(id+" Ma'lumot o`chirildi");
    }
    @PatchMapping("/student/{id}")
    public ResponseEntity patchUpdate(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity.ok(student);
    }

}
