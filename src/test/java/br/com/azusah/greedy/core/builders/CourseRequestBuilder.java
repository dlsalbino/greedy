package br.com.azusah.greedy.core.builders;

import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;

import java.time.LocalDate;

public class CourseRequestBuilder extends CourseBase {

    private CourseRequest request;

    private CourseRequestBuilder() {
    }

    public static CourseRequestBuilder defaultCourseRequest() {
        CourseRequestBuilder builder = new CourseRequestBuilder();
        builder.request = CourseRequest.builder()
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

    public CourseRequestBuilder withTitle(String title) {
        this.request.setTitle(title);
        return this;
    }

    public CourseRequestBuilder withModality(String modality) {
        this.request.setModality(modality);
        return this;
    }

    public CourseRequestBuilder startingOn(LocalDate date) {
        this.request.setStart(date);
        return this;
    }

    public CourseRequestBuilder finishOn(LocalDate date) {
        this.request.setFinish(date);
        return this;
    }

    public CourseRequestBuilder withAudience(String audience) {
        this.request.setAudience(audience);
        return this;
    }

    public CourseRequestBuilder withURL(String url) {
        this.request.setUrl(url);
        return this;
    }

    public CourseRequest build() {
        return this.request;
    }

}
