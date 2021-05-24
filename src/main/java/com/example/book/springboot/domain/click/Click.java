package com.example.book.springboot.domain.click;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
//테이블과 링크되는 클래스임을 나타냄
@Entity
public class Click {

    //해당 테이블의 기본 키임을 나타냄
    @Id
    //기본 키 생성을 데이터베이스에 위임
    //id 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 해준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private String createdDate;

    @CreatedDate
    private String createdTime;

    @Builder
    public Click(String createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist
    private void onPrePersist() {
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
    }
}
