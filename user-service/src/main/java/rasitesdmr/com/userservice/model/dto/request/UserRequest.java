package rasitesdmr.com.userservice.model.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String mail;
    private String password;
}
