package com.gitactions.gitactionscicd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PostsDto {
    private String title;
    private String content;
    private String author;
}
