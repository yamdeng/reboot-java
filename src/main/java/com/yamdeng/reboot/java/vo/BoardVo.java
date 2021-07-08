package com.yamdeng.reboot.java.vo;

import java.time.LocalDate;
import java.util.Objects;

public class BoardVo {

    private String title = "title";
    private String content;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private String ownerId;
    private Integer seq;

    public BoardVo() {

    }

    public BoardVo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardVo)) return false;
        BoardVo boardVo = (BoardVo) o;
        return Objects.equals(title, boardVo.title) && Objects.equals(content, boardVo.content) && Objects.equals(createdDate, boardVo.createdDate) && Objects.equals(lastModifiedDate, boardVo.lastModifiedDate) && Objects.equals(ownerId, boardVo.ownerId) && Objects.equals(seq, boardVo.seq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, createdDate, lastModifiedDate, ownerId, seq);
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", ownerId='" + ownerId + '\'' +
                ", seq=" + seq +
                '}';
    }
}
