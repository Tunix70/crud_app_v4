package com.tunix70.crudv4.model;

import javax.persistence.*;

@Entity
@Table(name = "region", schema = "public")
public class Region {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "region_id")
    private Long id;
    @Column (name = "name")
    private String name;

    public Region() {
    }

    public Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

