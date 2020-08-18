package com.example.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Posts 클래스로 DB를 접근하게 해줄 JpaRepository
//ibatis, MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자 이다.
//JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동 생성 된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY  p.id DESC")
    List<Posts> findAllDesc();

}
