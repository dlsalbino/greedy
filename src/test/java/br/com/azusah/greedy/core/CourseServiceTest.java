package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.core.builders.CourseBuilder;
import br.com.azusah.greedy.core.builders.CourseRequestBuilder;
import br.com.azusah.greedy.core.builders.CourseResponseBuilder;
import br.com.azusah.greedy.core.validators.InsertionRuleValidator;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import br.com.azusah.greedy.framework.mappers.Mapper;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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

    @Mock
    private InsertionRuleValidator insertionRuleValidator;

    @Test
    void shouldInsertACourse() {

        //given
        CourseRequest courseRequest = CourseRequestBuilder.defaultCourseRequest().build();
        CourseResponse courseResponse = CourseResponseBuilder.defaultCourseResponse().build();
        Course courseInput = CourseBuilder.defaultCourse().build();
        Course courseOutput = CourseBuilder.defaultCourse().withId("xyz").build();

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
                .isEqualToComparingFieldByField(courseResponse);

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