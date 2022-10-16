package com.gitactions.gitactionscicd.controller;

import com.gitactions.gitactionscicd.domain.Posts;
import com.gitactions.gitactionscicd.domain.PostsRepository;
import com.gitactions.gitactionscicd.dto.PostsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;

    @PostMapping("/posts")
    public Posts createPosts(@RequestBody PostsDto dto) {
        Posts posts = Posts.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();
        return postsRepository.save(posts);
    }

    @GetMapping("/posts")
    public List<PostsDto> ListAllPosts() {
        List<Posts> posts = postsRepository.findAll();
        List<PostsDto> postsDtos = new ArrayList<>();
        posts.stream().forEach(v -> {
            PostsDto post = PostsDto.builder()
                    .title(v.getTitle())
                    .content(v.getContent())
                    .author(v.getAuthor()).build();
            postsDtos.add(post);
        });
        return postsDtos;
    }

    @DeleteMapping("/posts")
    public Long deletePosts(@RequestParam Long id) {
        postsRepository.deleteById(id);
        return id;
    }

    @PutMapping("posts")
    public Long updatePosts(@RequestParam Long id,
                            @RequestBody PostsDto dto) {
        postsRepository.findById(id)
                .ifPresent(v -> {
                    v.setTitle(dto.getTitle());
                    v.setContent(dto.getContent());
                    v.setAuthor(dto.getAuthor());

                    postsRepository.save(v);
                });
        return id;
    }
}
