package io.github.arnabmaji19.attendancesystem.model;

import java.sql.Date;

public class AttendanceStatus {

    private Date date;
    private boolean present;

    public AttendanceStatus() {
    }

    public AttendanceStatus(Date date, boolean present) {
        this.date = date;
        this.present = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
