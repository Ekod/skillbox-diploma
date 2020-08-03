package skillbox.diploma.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserForApiPostResponse {
    private final int id;
    private final String name;
}
