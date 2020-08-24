package skillbox.diploma.service;

import skillbox.diploma.api.response.PostResponse;

public interface PostService {
    PostResponse getPosts(int offset, int limit, String mode);

    PostResponse getPostsBySearch(int offset, int limit, String query);

    PostResponse getPostsByDate(int offset, int limit, String date);

    PostResponse getPostsByTag(int offset, int limit, String tag);

    PostResponse getPostById(String id);
}
