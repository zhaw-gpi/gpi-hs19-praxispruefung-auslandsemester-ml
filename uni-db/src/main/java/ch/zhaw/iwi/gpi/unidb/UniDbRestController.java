package ch.zhaw.iwi.gpi.unidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UniDbRestController
 */
@RestController
public class UniDbRestController {

    @Autowired
    private UniversityRepository repository;

    @RequestMapping(path = "/unidb/university/{institution}", method = RequestMethod.GET)
    public ResponseEntity<University> getUniversity(@PathVariable String institution) {
        Optional<University> uni = repository.findById(institution);
        
        if(uni.isPresent()){
            return new ResponseEntity<University>(uni.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}