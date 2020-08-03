package skillbox.diploma.api.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiPostResponse {
    private int count;
    private List<ForApiPostResponse> posts;
}
