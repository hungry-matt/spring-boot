package com.example.book.springboot.service.posts;

import com.example.book.springboot.domain.click.Click;
import com.example.book.springboot.domain.click.ClickRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClickServiceTest {

    @Mock
    private ClickService clickService;

    @Mock
    private ClickRepository clickRepository;

    private Click click;

    @Before
    public void setUp() {
        this.clickService = new ClickService(clickRepository);

        click = Click.builder()
            .createdDate(clickService.getDate())
            .build();
    }

    @Test
    public void save() {
        given(clickRepository.save(any())).willReturn(click);

        Click click2 = clickService.save();

        verify(clickRepository).save(any());

        assertEquals(click.getCreatedDate(), click2.getCreatedDate());
    }

    @Test(expected = DuplicateKeyException.class)
    public void getCreatedDateWithExisted() {
        given(clickRepository.existsByCreatedDate(any())).willReturn(true);

        clickService.save();
    }

    @Test
    public void findAllByCreatedDate() {
        List<Click> mockList = new ArrayList<>();

        mockList.add(click);
        mockList.add(click);

        given(clickRepository.findAllByCreatedDate(click.getCreatedDate())).willReturn(mockList);

        List<Click> clickList = clickService.findAllByCreatedDate();

        assertEquals(2, clickList.size());
        System.out.println(clickList.get(0).getCreatedDate());
    }

}