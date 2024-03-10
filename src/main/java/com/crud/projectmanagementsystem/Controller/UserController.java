package com.crud.projectmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.crud.projectmanagementsystem.Entities.User;
import com.crud.projectmanagementsystem.Services.UserServices;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    // Api for creating the user
    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    // Api for deleting the user
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        boolean delete = this.userServices.deleteUser(id);
        if (delete) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Api for updating the user
    @PostMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateduser = this.userServices.updateUser(id, user);
        if (updateduser == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updateduser);
        }
    }

    // Api for get specific user by id
    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = this.userServices.getUser(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
           return ResponseEntity.notFound().build();
        }
    }

    //Api for get All Users 
    @GetMapping("/getAlluser")
    public List<User> getAllUsers(){
        return this.userServices.getAllUsers();
    }
}
