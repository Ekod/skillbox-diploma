package skillbox.diploma.api.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class ForApiPostResponse {

    private Integer id;
    private Date timestamp;
    private UserForApiPostResponse user;
    private String title;
    private String announce;
    private Integer likeCount;
    private Integer dislikeCount;
    private Integer commentCount;
    private Integer viewCount;

}