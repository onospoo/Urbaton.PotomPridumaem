package green.belka.backend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "achievementStatuses")
public class AchievementStatus {
    @Setter
    @Getter
    @Id
    private Long user_id;

    @Setter
    @Getter
    private Status status;

    @Setter
    @Getter
    private Long achievement_id;
}
