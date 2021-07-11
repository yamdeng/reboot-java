package com.yamdeng.reboot.java.vo;

import java.time.LocalDate;
import java.util.Objects;

public class BoardVo implements Comparable<BoardVo> {

    private String title = "title";
    private String content;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private String ownerId;
    private Integer seq;
    private BoardCategory boardCategory;
    private Integer price;
    private Boolean isNew;
    private BoardPublish boardPublish;

    public BoardVo(String title, String content, Integer seq, BoardCategory boardCategory) {
        this.title = title;
        this.content = content;
        this.seq = seq;
        this.createdDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.boardCategory = boardCategory;
    }

    public BoardVo(String title, String content, Integer seq, Boolean isNew, BoardCategory boardCategory, BoardPublish boardPublish) {
        this.title = title;
        this.content = content;
        this.seq = seq;
        this.createdDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.boardCategory = boardCategory;
        this.isNew = isNew;
        this.boardPublish = boardPublish;
    }

    @Override
    public int compareTo(BoardVo o) {
        if(o != null) {
            if(o.seq.intValue() == this.seq.intValue()) {
                return 0;
            } else if(o.seq.intValue() > this.seq.intValue()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BoardCategory getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(BoardCategory boardCategory) {
        this.boardCategory = boardCategory;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public BoardPublish getBoardPublish() {
        return boardPublish;
    }

    public void setBoardPublish(BoardPublish boardPublish) {
        this.boardPublish = boardPublish;
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
                ", boardCategory=" + boardCategory +
                ", isNew=" + isNew +
                ", boardPublish=" + boardPublish +
                '}';
    }
}
