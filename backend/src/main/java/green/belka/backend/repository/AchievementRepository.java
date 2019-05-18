package green.belka.backend.repository;

import green.belka.backend.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

}
