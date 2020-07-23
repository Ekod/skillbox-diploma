package skillbox.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import skillbox.diploma.model.enums.PostTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;

    @Column(name = "is_active")
    @NonNull
    private byte isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status")
    @NonNull
    private PostTypes moderationStatus;

    @Column(name = "moderator_id")
    private Integer moderatorId;

    @Column(name = "user_id")
    @NonNull
    private int userId;

    @NonNull
    private Timestamp time;

    @NonNull
    private String tte;

    @Lob
    @NonNull
    private String text;

    @Column(name = "view_count")
    @NonNull
    private int viewCount;
}
