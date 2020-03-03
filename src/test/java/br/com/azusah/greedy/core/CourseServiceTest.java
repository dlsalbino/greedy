package br.com.azusah.greedy.core;

import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CourseServiceTest {

    @Autowired
    public CourseService courseService;

    @Test
    void insert() {

        //given
        CourseRequest courseRequest = CourseRequest.builder()
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality("ONLINE")
                .start(LocalDate.of(2020,03,20))
                .finish(LocalDate.of(2020,03,20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience("ANYONE")
                .build();

        CourseResponse courseResponse = CourseResponse.builder()
                .id("xyz")
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality("ONLINE")
                .start(LocalDate.of(2020,03,20))
                .finish(LocalDate.of(2020,03,20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience("ANYONE")
                .build();

        //when
        courseService.insert(courseRequest);

        //then
        assertThat(courseResponse)
                .isEqualToComparingOnlyGivenFields(courseRequest, "title", "description");

    }

    @Test
    void getOne() {

        //given
        //when
        //then

    }

    @Test
    void getAll() {

        //given
        //when
        //then

    }

    @Test
    void update() {

        //given
        //when
        //then

    }

    @Test
    void deleteInALogicalWay() {

        //given
        //when
        //then

    }
}