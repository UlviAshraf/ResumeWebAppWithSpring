package com.company.resumerestapi.controller;

import com.company.entity.User;
import com.company.resumerestapi.dto.ResponseDTO;
import com.company.resumerestapi.dto.UserDTO;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    UserServiceInter repo;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "nid", required = false) Integer nid

    ) {
        List<User> list = repo.getAllUser(name, surname, nid);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            userDTOS.add(new UserDTO(u));
        }
//        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
        return ResponseEntity.ok(ResponseDTO.of(userDTOS));

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) {
        User user = repo.getById(id);
        UserDTO userDTOS = new UserDTO(user);
//        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
        return ResponseEntity.ok(ResponseDTO.of(userDTOS));

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        User user = repo.getById(id);
        repo.remove(id);
        UserDTO userDTOS = new UserDTO(user);
//        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
        return ResponseEntity.ok(ResponseDTO.of(userDTOS, "successfully deleted"));

    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        repo.addUser(user);
        return ResponseEntity.ok(ResponseDTO.of(user, "Successfully added"));
    }
}
