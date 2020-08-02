package skillbox.diploma.model;

import lombok.Getter;
import lombok.Setter;
import skillbox.diploma.model.enums.PostTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "posts")
@Getter
@Setter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_active")
    @NotNull
    private byte isActive;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "moderation_status")
    private PostTypes moderationStatus = PostTypes.NEW;

    @Column(name = "moderator_id")
    private Integer moderatorId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "posts")
    private User user;

    @NotNull
    private Timestamp time;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String text;

    @Column(name = "view_count")
    @NotNull
    private int viewCount;
}
