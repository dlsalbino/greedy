package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.core.validators.InsertionRuleValidator;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import br.com.azusah.greedy.framework.mappers.Mapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    public CourseService courseService;

    @Mock
    private Mapper modelMapper;

    @Mock
    private ICourseRepositoryPort courseRepository;

    @Mock
    private InsertionRuleValidator insertionRuleValidator;

    @Test @Disabled
    void insert() {

        //given

        CourseRequest courseRequest = CourseRequest.builder()
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality("ONLINE")
                .start(LocalDate.of(2020, 03, 20))
                .finish(LocalDate.of(2020, 03, 20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience("ANYONE")
                .build();

        CourseResponse courseResponse = CourseResponse.builder()
                .id("xyz")
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality("ONLINE")
                .start(LocalDate.of(2020, 03, 20))
                .finish(LocalDate.of(2020, 03, 20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience("ANYONE")
                .build();

        //when
        when(courseService.insert(courseRequest)).thenReturn(courseResponse);

        //then
        assertThat(courseResponse)
                .isEqualToComparingOnlyGivenFields(courseRequest, "title", "description");

    }

    @Test @Disabled
    void getOne() {

        //given
        String id = "xyz";
        CourseResponse courseResponse = CourseResponse.builder()
                .id("xyz")
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality("ONLINE")
                .start(LocalDate.of(2020, 03, 20))
                .finish(LocalDate.of(2020, 03, 20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience("ANYONE")
                .build();

        //when
        when(courseService.getOne(id)).thenReturn(courseResponse);

        //then
        assertThat(courseResponse).isNotNull();

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