package org.bbt.ciss.ciss.model.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IEvent 
{
    String getName();
    
    void setName(String name);
    
    String getRemark();
    
    void setRemark(String remark);
    
    ArrayList<Integer> getWeekAry();
    
    void setWeekAry(ArrayList<Integer> weekAry);
    
    int getDayOfWeek();
    
    void setDayOfWeek(int dayOfWeek);
    
    LocalDateTime getStartTime();
    
    void setStartTime(LocalDateTime startTime);
    
    LocalDateTime getEndTime();
    
    void setEndTime(LocalDateTime endTime);
    
    String getLocation();
    
    void setLocation(String location);
}
