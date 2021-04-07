package com.tunix70.crudv4.model;

import com.tunix70.crudv4.util.TimeStampToLongConverter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "post", schema = "public")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    @Convert(converter = TimeStampToLongConverter.class)
    private Long created;
    @Column(name = "updated")
    @Convert(converter = TimeStampToLongConverter.class)
    private Long updated;
    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    public Post() {
    }

    public Post(String content, Long created, Long updated, PostStatus postStatus) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.postStatus = postStatus;
    }

    public Post(Long id, String content, Long created, Long updated, PostStatus postStatus) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.postStatus = postStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", postStatus=" + postStatus +
                '}';
    }
}