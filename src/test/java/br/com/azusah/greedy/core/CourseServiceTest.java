package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import br.com.azusah.greedy.framework.mappers.Mapper;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import br.com.azusah.greedy.framework.repositories.entities.enums.AudienceType;
import br.com.azusah.greedy.framework.repositories.entities.enums.ModalityType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    public CourseService courseService;

    @Mock
    private Mapper mapper;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ICourseRepositoryPort courseRepository;

    @Test
    void shouldToInsertAnCourse() {

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

        Course courseInput = Course.builder()
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality(ModalityType.ONLINE)
                .start(LocalDate.of(2020, 03, 20))
                .finish(LocalDate.of(2020, 03, 20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience(AudienceType.ANYONE)
                .build();

        Course courseOutput = Course.builder()
                .id("xyz")
                .title("Java Functional Approach")
                .description("A new course of Java")
                .modality(ModalityType.ONLINE)
                .start(LocalDate.of(2020, 03, 20))
                .finish(LocalDate.of(2020, 03, 20))
                .url("http://udemy.com")
                .instructor("James Gosling")
                .audience(AudienceType.ANYONE)
                .build();

        //when
        when(courseRepository.insert(any(Course.class))).thenReturn(courseOutput);
        when(mapper.mapper()).thenReturn(modelMapper);
        when(modelMapper.map(any(CourseRequest.class), any())).thenReturn(courseInput);
        when(modelMapper.map(any(Course.class), any())).thenReturn(courseResponse);
        when(courseService.insert(courseRequest)).thenReturn(courseResponse);

        CourseResponse saved = courseService.insert(courseRequest);

        //then
        assertThat(saved)
                .isNotNull()
                .isEqualTo(courseResponse);

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