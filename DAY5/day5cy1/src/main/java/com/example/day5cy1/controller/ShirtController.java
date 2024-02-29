package com.example.day5cy1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.day5cy1.model.Shirt;
import com.example.day5cy1.service.ShirtService;

@RestController
public class ShirtController {
    private ShirtService shirtService;

    public ShirtController(ShirtService shirtService)
    {
        this.shirtService=shirtService;
    }

    @PostMapping("/shirt")
    public ResponseEntity<Shirt> postMethodName(@RequestBody Shirt shirt) {
        if (shirtService.saveShirt(shirt) == true) {
            return new ResponseEntity<>(shirt, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(shirt, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/shirt")
    public ResponseEntity<List<Shirt>> putMethodName() {
        List<Shirt> l = shirtService.getListShirt();
        if (l.size() == 0) {
            return new ResponseEntity<>(l, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
    @GetMapping("/shirt/{shirtId}")
    public ResponseEntity<Shirt> putMethodName(@PathVariable("shirtId") int id) {
        Shirt p = shirtService.getShirtById(id);
        if (p!=null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }
    @PutMapping("/shirt/{shirtId}")
    public ResponseEntity<Shirt> putMethodName(@PathVariable("shirtId") int id, @RequestBody Shirt shirt) {
        if (shirtService.updateDetails(id, shirt) == true) {
            return new ResponseEntity<>(shirt, HttpStatus.OK);
        }
        return new ResponseEntity<>(shirt, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/shirt/{shirtId}")
    public boolean delete(@PathVariable("shirtId") int id) {
        if (shirtService.deleteShirt(id) == true) {
            return true;
        }
        return false;
    }
}
