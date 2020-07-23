package skillbox.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;

    @Column(name = "is_moderator")
    @NonNull
    private byte isModerator;

    @Column(name = "reg_time")
    @NonNull
    private Timestamp regTime;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String code;

    @Lob
    private String photo;
}
