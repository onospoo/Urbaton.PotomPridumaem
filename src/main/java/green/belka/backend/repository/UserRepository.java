package green.belka.backend.repository;

import green.belka.backend.model.Role;
import green.belka.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);
}
