package ra.model.dto;

import java.sql.Date;

public class FormFeedBackDto {
    private Long id;
    private int rate;
    private String author;
    private String content;
    private Date date;
    private int like;

    public FormFeedBackDto() {
    }

    public FormFeedBackDto(Long id, int rate, String author, String content, Date date, int like) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.content = content;
        this.date = date;
        this.like = like;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
