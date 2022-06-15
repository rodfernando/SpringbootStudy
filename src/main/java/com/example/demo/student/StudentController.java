package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API layer
 */
@RestController
@RequestMapping(path = "api/v1/student") //localhost:8080/api/v1/student
public class StudentController {

    /**
     * Ligação entre a API e regras de negócio
     */
    private final StudentService studentService; //add construtor

    /**
     * Injeção de dependência: a classe studentService é instanciado no construtor.
     * É o mesmo que 'this.studentService = new studentService();
     * @param studentService // O construtor aqui é o ponto de injeção.
     * o @Autowired é um definição de qual construtor será utilizado em caso de sobrecarga
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //API que irá armazenar os dados dos clientes

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@
          PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
