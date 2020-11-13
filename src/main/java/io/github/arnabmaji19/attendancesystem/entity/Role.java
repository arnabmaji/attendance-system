package io.github.arnabmaji19.attendancesystem.entity;

import io.github.arnabmaji19.attendancesystem.model.AppRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private AppRole name;

    public Role() {
    }

    public Role(int id, AppRole name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppRole getName() {
        return name;
    }

    public void setName(AppRole name) {
        this.name = name;
    }
}
