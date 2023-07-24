package rasitesdmr.com.userservice.service;

import rasitesdmr.com.userservice.model.User;
import rasitesdmr.com.userservice.model.dto.request.UserRequest;
import rasitesdmr.com.userservice.model.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserResponseByUserName(String username);

    User getUserByUserName(String username);

    boolean isCheckUser(String username);

    List<User> getAllUsers();

    List<UserResponse> getAllUserResponses();

    User getUserById(Long id);

    UserResponse updateUser(Long id ,UserRequest userRequest);

    void updateUserFields(User user,UserRequest userRequest);

    void deleteUser(Long id);


}
