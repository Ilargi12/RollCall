package pl.RollCall.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.RollCall.exceptions.UserNotFoundException;
import pl.RollCall.model.User;
import pl.RollCall.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id){
        return userService.getUserById(id).
                orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    public User createRoom(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }





}
