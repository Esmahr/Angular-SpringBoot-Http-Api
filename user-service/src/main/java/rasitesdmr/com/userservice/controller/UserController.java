package rasitesdmr.com.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rasitesdmr.com.userservice.model.dto.request.UserRequest;
import rasitesdmr.com.userservice.model.dto.response.UserResponse;
import rasitesdmr.com.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(maxAge = 3600)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<UserResponse> findUserResponseByUserName(@PathVariable(name = "username") String username) {
        return new ResponseEntity<>(userService.findUserResponseByUserName(username), HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<UserResponse>> findAllUserResponses() {
        return new ResponseEntity<>(userService.findAllUserResponses(), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(userRequest), HttpStatus.OK);
    }

    @DeleteMapping(path = "")
    public void deleteUser(@RequestParam String username) {
        userService.deleteUser(username);
    }


}
