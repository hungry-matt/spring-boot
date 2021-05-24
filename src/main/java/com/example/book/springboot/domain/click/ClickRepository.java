package com.example.book.springboot.domain.click;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClickRepository extends JpaRepository<Click, Long> {

    @Query("SELECT c FROM Click c WHERE c.createdDate = :date")
    List<Click> findAllByCreatedDate(@Param("date") String date);

    boolean existsByCreatedDate(String date);
}
