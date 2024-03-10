package com.crud.projectmanagementsystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.crud.projectmanagementsystem.Dao.UserRepository;
import com.crud.projectmanagementsystem.Entities.User;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void initialize() {
        userRepository.dropUserTable();
    }

    // for the add user
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    // for the user delete by id
    public boolean deleteUser(Long id) {
        if (id != null) {
            User user = this.userRepository.findById(id).get();
            this.userRepository.delete(user);
            return true;
        }
        return false;
    }

    // for the user update
    public User updateUser(Long id, User user) {
        if (!this.userRepository.existsById(id)) {
            return null;
        }
        user.setId(id);
        return this.userRepository.save(user);
    }

    // for the find particular user by the id
    public User getUser(Long id) {
        if (id != null) {
            return this.userRepository.findById(id).get();
        }
        return null;
    }

    // for the find all users
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
