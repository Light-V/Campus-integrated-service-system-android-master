package org.bbt.ciss.ciss.model.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * POJO
 * Concrete event information
 * @author Yukino Yukinoshita
 */

public class ConcreteEvent implements IEvent {
    
    private String name;
    private String remark;
    private ArrayList<Integer> weekAry;
    private int dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    
    public ConcreteEvent(){
        weekAry = new ArrayList<>();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getRemark() {
        return remark;
    }
    
    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Override
    public ArrayList<Integer> getWeekAry() {
        return weekAry;
    }
    
    @Override
    public void setWeekAry(ArrayList<Integer> weekAry) {
        this.weekAry = weekAry;
    }
    
    @Override
    public int getDayOfWeek() {
        return dayOfWeek;
    }
    
    @Override
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    @Override
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    @Override
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    @Override
    public String getLocation() {
        return location;
    }
    
    @Override
    public void setLocation(String location) {
        this.location = location;
    }
    
}
