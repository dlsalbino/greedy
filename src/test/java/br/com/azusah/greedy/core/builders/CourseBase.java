package br.com.azusah.greedy.core.builders;

import br.com.azusah.greedy.framework.repositories.entities.Location;

import java.time.LocalDate;

public class CourseBase {

    protected static final String ID = "507f191e810c19729de860ea";
    protected static final String TITLE = "Java a Functional Approach";
    protected static final String MODALITY = "ONLINE";
    protected static final String DESCRIPTION = "A new course of Java";
    protected static final LocalDate START = LocalDate.of(2020, 03, 20);
    protected static final LocalDate FINISH = LocalDate.of(2020, 03, 20);
    protected static final String INSTRUCTOR = "James Gosling";
    protected static final String AUDIENCE = "ANYONE";
    protected static final Location LOCATION = Location.builder().build();
    protected static final String URL = "http://udemy.com";
    protected static final boolean ACTIVE = true;

}
