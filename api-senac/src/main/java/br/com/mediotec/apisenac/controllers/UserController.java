package br.com.mediotec.apisenac.controllers;

import br.com.mediotec.apisenac.dto.UserDTO;
import br.com.mediotec.apisenac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
