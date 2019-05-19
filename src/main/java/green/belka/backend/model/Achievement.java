package green.belka.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "achievements")
public class Achievement {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter
    @Setter
    private Long authorId;

    @Setter
    @Getter
    private String description;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Long cost;

    @Getter
    @Setter
    @JsonIgnore
    private LocalDate create_date;

    @Getter
    @Setter
    private Long achievement_limit;

    @Setter
    @Getter
    private String avatar;

    public Achievement() {
        for(int i = 0; i < 10; ++i) {
            keys.add(UUID.randomUUID());
        }
    }

    @Setter
    @Getter
    @ElementCollection
    private Set<UUID> keys = new HashSet<>();
}
