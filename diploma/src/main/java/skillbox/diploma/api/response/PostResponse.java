package skillbox.diploma.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse { //<----название класса указывает на путь по которому будет отправлен ответ /api/post

    private int count;
    private List<PostResponseList> posts;
}
