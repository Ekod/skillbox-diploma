package skillbox.diploma.response;

import lombok.Data;
import skillbox.diploma.model.Posts;

import java.util.List;

@Data
public class ApiPostResponse {
    private int count;
    private List<Posts> posts;
}
