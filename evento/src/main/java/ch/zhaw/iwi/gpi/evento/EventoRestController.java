package ch.zhaw.iwi.gpi.evento;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * EventoRestController
 */
@RestController
public class EventoRestController {

    @Autowired
    private StudentGradesRepository repository;

    @RequestMapping(path = "/evapi/studentgrades/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<StudentGrades> getStudentGrades(@PathVariable String studentId) {
        Optional<StudentGrades> grades = repository.findById(studentId);

        if(grades.isPresent()){
            return new ResponseEntity<StudentGrades>(grades.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}