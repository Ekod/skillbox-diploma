package skillbox.diploma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class ApiPostController {

    @GetMapping("/{mode}")
    public void getPosts(@RequestParam(name = "offset", defaultValue = "0") int offset,
                         @RequestParam(name = "limit", defaultValue = "20") int limit,
                         @PathVariable String mode
    ) {

    }
}


//offset - сдвиг от 0 для постраничного вывода
//limit - количество постов, которое надо вывести
//mode - режим вывода (сортировка):
//recent - сортировать по дате публикации, выводить сначала новые
//popular - сортировать по убыванию количества комментариев
//best - сортировать по убыванию количества лайков
//early - сортировать по дате публикации, выводить сначала старые