package br.com.azusah.greedy.core.builders;

import br.com.azusah.greedy.framework.repositories.entities.Course;
import br.com.azusah.greedy.framework.repositories.entities.enums.AudienceType;
import br.com.azusah.greedy.framework.repositories.entities.enums.ModalityType;

import java.time.LocalDate;

public class CourseBuilder extends CourseBase {

    private Course course;

    private CourseBuilder() {
    }

    public static CourseBuilder defaultCourse() {
        CourseBuilder builder = new CourseBuilder();
        builder.course = Course.builder()
                .title(TITLE)
                .description(DESCRIPTION)
                .modality(ModalityType.ONLINE)
                .start(START)
                .finish(FINISH)
                .url(URL)
                .instructor(INSTRUCTOR)
                .audience(AudienceType.ANYONE)
                .build();
        return builder;
    }

    public CourseBuilder withId(String id) {
        this.course.setId(id);
        return this;
    }

    public CourseBuilder withTitle(String title) {
        this.course.setTitle(title);
        return this;
    }

    public CourseBuilder withModality(ModalityType modality) {
        this.course.setModality(modality);
        return this;
    }

    public CourseBuilder startingOn(LocalDate date) {
        this.course.setStart(date);
        return this;
    }

    public CourseBuilder finishOn(LocalDate date) {
        this.course.setFinish(date);
        return this;
    }

    public CourseBuilder withAudience(AudienceType audience) {
        this.course.setAudience(audience);
        return this;
    }

    public CourseBuilder withURL(String url) {
        this.course.setUrl(url);
        return this;
    }

    public Course build() {
        return this.course;
    }

}
