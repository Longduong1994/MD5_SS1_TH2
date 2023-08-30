package ra.model.entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
public class FeedBack {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    private String content;
    private Date date;
    private int like;
    public FeedBack() {
    }

    public FeedBack(Long id, int rate, String author, String content, Date creationDate, int likes) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.content = content;
        this.date = creationDate;
        this.like = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return date;
    }

    public void setCreationDate(Date creationDate) {
        this.date = creationDate;
    }

    public int getLikes() {
        return like;
    }

    public void setLikes(int likes) {
        this.like = likes;
    }

    public void clone(FeedBack f) {
        this.id = f.getId();
        this.rate = f.getRate();
        this.author = f.getAuthor();
        this.content = f.getContent();
        this.date = f.getCreationDate();
        this.like = f.getLikes();
    }
}