package com.toyspring.noticeBoard.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private String title;
    private String contents;
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
