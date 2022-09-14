package com.toyspring.noticeBoard.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoPostDto {



    @NotBlank(message = "타이틀은 공백일 수 없습니다.")
    private String title;

    //@NotBlank(message = "내용은 공백일 수 없습니다.")

    private String contents;

}
