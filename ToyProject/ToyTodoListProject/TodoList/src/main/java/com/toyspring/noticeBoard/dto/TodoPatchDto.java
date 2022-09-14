package com.toyspring.noticeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoPatchDto {


    private Long TodoId;

    @NotBlank(message = "타이틀은 공백일 수 없습니다.")
    private String title;

    //@NotBlank(message = "내용은 공백일 수 없습니다.")
    private String contents;
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
