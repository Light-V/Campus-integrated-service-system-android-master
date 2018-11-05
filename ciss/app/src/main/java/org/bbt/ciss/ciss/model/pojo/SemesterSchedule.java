package org.bbt.ciss.ciss.model.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * POJO
 * Schedule in a semester
 *
 * @author Yukino Yukinoshita
 */

public class SemesterSchedule {
    
    private LocalDateTime semesterStartTime;
    private int weekThisSemester;
    private ArrayList<IEvent> eventArrayList;
    
    public SemesterSchedule() {
        eventArrayList = new ArrayList<>();
    }
    
    public LocalDateTime getSemesterStartTime() {
        return semesterStartTime;
    }
    
    public void setSemesterStartTime(LocalDateTime semesterStartTime) {
        this.semesterStartTime = semesterStartTime;
    }
    
    public int getWeekThisSemester() {
        return weekThisSemester;
    }
    
    public void setWeekThisSemester(int weekThisSemester) {
        this.weekThisSemester = weekThisSemester;
    }
    
    public ArrayList<IEvent> getEventArrayList() {
        return eventArrayList;
    }
    
    public void setEventArrayList(ArrayList<IEvent> eventArrayList) {
        this.eventArrayList = eventArrayList;
    }
}
