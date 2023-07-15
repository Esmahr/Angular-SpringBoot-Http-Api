package rasitesdmr.com.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rasitesdmr.com.userservice.exception.AlreadyAvailableException;
import rasitesdmr.com.userservice.exception.NotAvailableException;
import rasitesdmr.com.userservice.model.User;
import rasitesdmr.com.userservice.model.dto.request.UserRequest;
import rasitesdmr.com.userservice.model.dto.response.UserResponse;
import rasitesdmr.com.userservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        if (isCheckUser(userRequest.getUsername())) {
            log.warn(String.format("[Method Name : %s] - A user with the username %s already exists.", methodName, userRequest.getUsername()));
            throw new AlreadyAvailableException(String.format("A user with the username %s already exists.", userRequest.getUsername()));
        }
        User user = new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getUsername(), userRequest.getMail(), userRequest.getPassword());
        userRepository.save(user);
        log.info(String.format("[Method Name : %s] - The user with username %s has been successfully registered.", methodName, user.getUsername()));
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getMail());
    }

    @Override
    public UserResponse getUserResponseByUserName(String username) {
        User user = getUserByUserName(username);
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getMail());
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isCheckUser(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserResponse> getAllUserResponses() {
        List<User> users = getAllUsers();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getMail());
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotAvailableException("User Not Found"));
    }

    @Override
    public UserResponse updateUser(Long id ,UserRequest userRequest) {
        User currentUser = getUserById(id);
        updateUserFields(currentUser, userRequest);
        userRepository.save(currentUser);
        return new UserResponse(currentUser.getId(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getUsername(), currentUser.getMail());
    }

    @Override
    public void updateUserFields(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUsername(userRequest.getUsername());
        user.setMail(userRequest.getMail());
        user.setPassword(userRequest.getPassword());
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
