package skillbox.diploma.service;

import skillbox.diploma.api.response.PostResponse;

public interface PostService {
    PostResponse getPosts(int offset, int limit, String mode);

    PostResponse getPostsSearch(int offset, int limit, String query);

    PostResponse getPostsDate(int offset, int limit, String date);

    PostResponse getPostsTag(int offset, int limit, String tag);
}
