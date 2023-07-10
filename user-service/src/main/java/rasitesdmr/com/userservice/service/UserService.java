package rasitesdmr.com.userservice.service;

import rasitesdmr.com.userservice.model.User;
import rasitesdmr.com.userservice.model.dto.request.UserRequest;
import rasitesdmr.com.userservice.model.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse findUserResponseByUserName(String username);

    User findUserByUserName(String username);

    boolean isCheckUser(String username);

    List<User> findAllUsers();

    List<UserResponse> findAllUserResponses();

    User findUserById(Long id);

    UserResponse updateUser(UserRequest userRequest);

    void updateUserFields(User user,UserRequest userRequest);

    void deleteUser(String username);


}
