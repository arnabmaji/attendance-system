package io.github.arnabmaji19.attendancesystem.entity;

import javax.persistence.*;

// TODO: Fix Foreign Key issues
@Entity
@Table(name = "student_details")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "parent_phone")
    private String parentPhone;

    public StudentDetail() {
    }

    public StudentDetail(User user, String parentPhone) {
        this.user = user;
        this.parentPhone = parentPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }
}
