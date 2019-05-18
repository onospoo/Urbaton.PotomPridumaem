package green.belka.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "achievements")
public class Achievement {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Setter
//    @Getter
//    @ManyToMany(cascade=CascadeType.MERGE)
//    @JoinColumn(name = "achievements")
//    private List<User> users;

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
    private Status status;

    @Getter
    @Setter
    @JsonIgnore
    private LocalDate create_date;

    @Getter
    @Setter
    private Long achievement_limit;

}
