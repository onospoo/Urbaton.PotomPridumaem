package green.belka.backend.repository;

import green.belka.backend.model.Achievement;
import green.belka.backend.model.AchievementStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementStatusRepository extends JpaRepository<AchievementStatus, Long> {

}