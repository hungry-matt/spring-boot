package com.example.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//보통 entity 에는 해당 데이터의 생성, 수정 시간을 포함.
//유지보수에 있어 굉장히 중요한 정보.
//그렇다 보니 반복된 date 삽입, 갱신 코드가 작성됨.
//그래서 반복적인 코드가 작성되지 않게 JPA Auditing 을 사용.
@Getter
//entity 들이 BaseTimeEntity 를 상속할 경우 필드들도 컬럼으로 인식하도록 한다.
@MappedSuperclass
//해당 클래스에 Auditing 기능을 포함 시킨다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    //entity 가 생성되어 저장될때 시간이 자동 저장.
    @CreatedDate
    private LocalDateTime createdDate;

    //조회된 entity 의 값을 변경할때 시간이 자동 저장.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
