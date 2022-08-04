package com.sparta.jwtt.model;

import com.sparta.jwtt.Dto.noticeDto;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@RestController
@Entity
public class notice {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private  String content;

    @Column(nullable = false)
    private String author;
    private String nickname;

    public notice () {
        this.title = title;
        this.content = content;
        this.author = String.valueOf(nickname);
    }

    public notice(noticeDto requestDto) {}
}

