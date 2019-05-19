package green.belka.backend.repository;

import green.belka.backend.model.AchievementStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AchievementStatusRepository extends JpaRepository<AchievementStatus, Long> {

}