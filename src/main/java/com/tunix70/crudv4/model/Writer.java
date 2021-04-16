package com.tunix70.crudv4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writer", schema = "public")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "writer_id")
    private Long id;
    @Column (name = "firstname")
    private String firstName;
    @Column (name = "lastname")
    private String lastName;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "writer",
            cascade = CascadeType.ALL)
    private List<Post> post;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


    public Writer(){}

    public Writer(Long id, String firstName, String lastName, List<Post> post, Region region) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.post = post;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", post=" + post +
                ", region=" + region +
                '}';
    }
}
