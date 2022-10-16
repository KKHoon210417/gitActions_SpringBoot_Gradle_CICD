package com.gitactions.gitactionscicd.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
@Getter
@Setter
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        Assert.hasText(title, "title must not be empty");
        Assert.hasText(title, "content must not be empty");
        Assert.hasText(title, "author must not be empty");

        this.title = title;
        this.content = content;
        this.author = author;
    }
}
