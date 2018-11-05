package org.bbt.ciss.ciss.presenter;

import org.bbt.ciss.ciss.BasePresenter;
import org.bbt.ciss.ciss.model.pojo.Course;
import org.bbt.ciss.ciss.model.pojo.IEvent;
import org.bbt.ciss.ciss.model.pojo.SemesterSchedule;
import org.bbt.ciss.ciss.view.SemesterScheduleView;

/**
 * @author Yukino Yukinoshita
 */

public class SemesterSchedulePresenter implements BasePresenter {

    private SemesterScheduleView semesterScheduleView;
    private SemesterSchedule semesterSchedule;

    public SemesterSchedulePresenter(SemesterScheduleView semesterScheduleView, SemesterSchedule semesterSchedule){
        this.semesterScheduleView = semesterScheduleView;
        this.semesterSchedule = semesterSchedule;
    }

    public void addCourse(String name){
        Course course = new Course();
        course.setName(name);
        semesterSchedule.getEventArrayList().add(course);
    }

    public void getCourse(){
        IEvent event = semesterSchedule.getEventArrayList().get(0);
        semesterScheduleView.showCourse(event.getName());
    }

}
