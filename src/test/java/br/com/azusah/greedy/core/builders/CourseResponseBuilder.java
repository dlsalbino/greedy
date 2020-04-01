package br.com.azusah.greedy.core.builders;

import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;

import java.time.LocalDate;

public class CourseResponseBuilder extends CourseBase {

    private CourseResponse response;

    private CourseResponseBuilder() {
    }

    public static CourseResponseBuilder defaultCourseResponse() {
        CourseResponseBuilder builder = new CourseResponseBuilder();
        builder.response = CourseResponse.builder()
            .id(ID)
            .title(TITLE)
            .description(DESCRIPTION)
            .modality(MODALITY)
            .start(START)
            .finish(FINISH)
            .url(URL)
            .instructor(INSTRUCTOR)
            .audience(AUDIENCE)
            .build();
        return builder;
    }

    public CourseResponseBuilder withTitle(String title) {
        this.response.setTitle(title);
        return this;
    }

    public CourseResponseBuilder withModality(String modality) {
        this.response.setModality(modality);
        return this;
    }

    public CourseResponseBuilder startingOn(LocalDate date) {
        this.response.setStart(date);
        return this;
    }

    public CourseResponseBuilder finishOn(LocalDate date) {
        this.response.setFinish(date);
        return this;
    }

    public CourseResponseBuilder withAudience(String audience) {
        this.response.setAudience(audience);
        return this;
    }

    public CourseResponseBuilder withURL(String url) {
        this.response.setUrl(url);
        return this;
    }

    public CourseResponse build() {
        return this.response;
    }

}
