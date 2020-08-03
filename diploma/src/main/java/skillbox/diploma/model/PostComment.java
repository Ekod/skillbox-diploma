package skillbox.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "post_comments")
@Getter
@Setter
public class PostComment {

    @Id
    private int id;

    @NotNull
    @Column(name = "parent_id")
    private Integer parentId;

    @NotNull
    @Column(name = "post_id")
    private int postId;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    private Timestamp time;

    @Lob
    @NotNull
    private String text;

}
