package com.example.book.springboot.service.posts;

import com.example.book.springboot.domain.click.Click;
import com.example.book.springboot.domain.click.ClickRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClickService {

    private final ClickRepository clickRepository;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public ClickService(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    @Transactional
    public Click save() {
        if (existsByCreatedDate()) {
            throw new DuplicateKeyException("이미 등록 되었습니다.");
        }

        return clickRepository.save(new Click());
    }

    public boolean existsByCreatedDate() {
        return clickRepository.existsByCreatedDate(getDate());
    }

    public List<Click> findAllByCreatedDate() {
        return clickRepository.findAllByCreatedDate(getDate());
    }

    public String getDate() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }
}
