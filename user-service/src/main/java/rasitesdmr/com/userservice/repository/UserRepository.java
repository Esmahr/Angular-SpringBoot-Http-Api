package rasitesdmr.com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rasitesdmr.com.userservice.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
