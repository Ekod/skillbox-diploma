package skillbox.diploma.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skillbox.diploma.api.response.PostResponse;
import skillbox.diploma.service.PostService;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class ApiPostController {

    PostService postService;

    @GetMapping
    public ResponseEntity<PostResponse> getPosts(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "20") int limit,
            @RequestParam(name = "mode", defaultValue = "recent") String mode
    ) {
        PostResponse returnValue = postService.getPosts(offset, limit, mode);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<PostResponse> getPostsBySearch(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "20") int limit,
            @RequestParam(name = "query", defaultValue = "20") String query
    ) {
        PostResponse returnValue = postService.getPostsSearch(offset, limit, query);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @GetMapping("/byDate")
    public ResponseEntity<PostResponse> getPostsByDate(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "20") int limit,
            @RequestParam(name = "date") String date
    ) {
        PostResponse returnValue = postService.getPostsDate(offset, limit, date);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @GetMapping("/byTag")
    public ResponseEntity<PostResponse> getPostsByTag(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "20") int limit,
            @RequestParam(name = "tag") String tag
    ) {
        PostResponse returnValue = postService.getPostsTag(offset, limit, tag);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}

