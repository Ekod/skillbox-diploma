package skillbox.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "post_votes")
@Getter
@Setter
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Column(name = "post_id")
    private int postId;

    @NotNull
    private Timestamp time;

    @NotNull
    private byte value;
}
