package com.springbt.spamanagement.controller;

import antlr.ASTNULLType;
import com.springbt.spamanagement.exception.ResourceNotFoundException;
import com.springbt.spamanagement.model.Employee;
import com.springbt.spamanagement.model.Expert;
import com.springbt.spamanagement.repository.ExpertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/v1/spa")
public class ExpertsController {

    @Autowired
    private ExpertsRepository expertsRepository;

    @GetMapping("/experts")
    public List<Expert> getAllExperts(){
        return  expertsRepository.findAll();
    }

    @PostMapping("/experts")
    public Expert createExpert(@Valid @RequestBody Expert expert){
       return expertsRepository.save(expert);
    }

    @DeleteMapping("/experts/{id}")
    public Map<String, Boolean> deleteExpert(@PathVariable(value = "id") Long expertId)
            throws ResourceNotFoundException {
        Expert expert = expertsRepository.findById(expertId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expertId));

        expertsRepository.delete(expert);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/experts/{id}")
    public ResponseEntity<Expert> getExpertByID(@PathVariable(value = "id") Long expertId)
            throws ResourceNotFoundException {
        Expert expert = expertsRepository.findById(expertId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expertId));
        return ResponseEntity.ok().body(expert);
    }


    @PutMapping("/experts/{id}")
    public ResponseEntity<Expert> updateExpert(@PathVariable(value = "id") Long expertId,
                                                   @Valid @RequestBody Expert expertDetails) throws ResourceNotFoundException {
        Expert expert = expertsRepository.findById(expertId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + expertId));

        expert.setExpertise(expertDetails.getExpertise());
        expert.setName(expertDetails.getName());
        expert.setPhone(expertDetails.getPhone());

        final Expert updatedEmployee = expertsRepository.save(expert);
        return ResponseEntity.ok(updatedEmployee);
    }
}
