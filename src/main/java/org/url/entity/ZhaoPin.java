package org.url.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ZhaoPin {
    @Column(name="title")
    private String title;
    @Column(name="url")
    private String url;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="create_time")
    private Date createTime;

    public ZhaoPin(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public ZhaoPin() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ZhaoPin{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
