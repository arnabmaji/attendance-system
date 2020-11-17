package io.github.arnabmaji19.attendancesystem.model;

import java.sql.Date;
import java.util.List;

public class LectureDetails {

    private int id;
    private Date date;
    private List<String> attendanceList;

    public LectureDetails() {
    }

    public LectureDetails(int id, Date date, List<String> attendanceList) {
        this.id = id;
        this.date = date;
        this.attendanceList = attendanceList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<String> attendanceList) {
        this.attendanceList = attendanceList;
    }
}
