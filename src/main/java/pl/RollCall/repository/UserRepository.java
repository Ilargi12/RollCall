package pl.RollCall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.RollCall.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
