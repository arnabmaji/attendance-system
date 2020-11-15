package io.github.arnabmaji19.attendancesystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentDetail {

    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "parent_phone")
    private String parentPhone;

    public StudentDetail() {
    }

    public StudentDetail(int id, String parentPhone) {
        this.id = id;
        this.parentPhone = parentPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }
}
