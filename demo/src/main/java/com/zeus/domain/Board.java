package com.zeus.domain;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@NoArgsConstructor // 기본생성자
@RequiredArgsConstructor
@Getter // getter 생성자
@Setter // setter 생성자
@ToString // ToString
@AllArgsConstructor // 모든 생성자 만들기
@EqualsAndHashCode(of = {"boardNo","title"})
@Data // 위 5개 코드 모든걸 다 대체한다.
public class Board {
    // 멤버변수
    private int boardNo;
    @NonNull
    private String title;
    private String content;
    private String writer;
    private Date regDate;

}
