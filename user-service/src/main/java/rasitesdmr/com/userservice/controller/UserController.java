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
    public ResponseEntity<UserResponse> getUserResponseByUserName(@PathVariable(name = "username") String username) {
        return new ResponseEntity<>(userService.getUserResponseByUserName(username), HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<UserResponse>> getAllUserResponses() {
        return new ResponseEntity<>(userService.getAllUserResponses(), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable(name = "id")Long id,@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(id,userRequest), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id ) {
        userService.deleteUser(id);
    }


}
