package rasitesdmr.com.userservice.model.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String mail;

    public UserResponse() {
    }

    public UserResponse(Long id, String firstName, String lastName, String username, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.mail = mail;
    }
}
