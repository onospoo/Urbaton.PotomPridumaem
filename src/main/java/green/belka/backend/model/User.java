package green.belka.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Setter
    @Getter
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Getter
    @ManyToMany(cascade={CascadeType.MERGE})
    @JoinColumn(name = "users")
    private List<Achievement> achievements;

    @Setter
    @Getter
    private Role role;

    @Getter
    @Setter
    private String nickname;

    @Getter
    @Setter
    private String first_name;

    @Getter
    @Setter
    private String last_name;

    @Getter
    @Setter
    private Long score;
}