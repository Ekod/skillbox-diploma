package skillbox.diploma.api.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiPostResponse { //<----название класса указывает на путь по которому будет отправлен ответ /api/post

    private int count;
    private List<ForApiPostResponse> posts;
}
