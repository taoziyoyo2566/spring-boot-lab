package net.taoziyoyo.controller;

import net.taoziyoyo.model.User;
import net.taoziyoyo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Value("${custom.welcome-message}")
    private String welcomeMessage;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

//    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        try {
            List<User> users = userService.getAllUsers();
            logger.info("listUsers run at {}", LocalDateTime.now());
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            // 记录错误日志
            logger.error(e.getMessage());
            // 返回错误响应
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("name/{name}")
    public User findByName(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }

}