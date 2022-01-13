package com.cptbrk.api;

import com.cptbrk.entity.User;
import com.cptbrk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
/*
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Burak");
        user.setSurname("Çalışgan");
        HashMap<String, String> info = new HashMap<String, String>();
        info.put("Country", "Turkey");
        info.put("City", "Istanbul");
        info.put("Age", "26");
        user.setMoreInfo(info);

        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> addUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
