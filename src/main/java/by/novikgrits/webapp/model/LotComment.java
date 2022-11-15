package by.novikgrits.webapp.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class LotComment {
    private Integer id;
    private Integer lotId;
    private Integer authorId;
    private String text;
    private LocalDateTime sendingTime;

    public LotComment(Integer lotId, Integer authorId, String text, LocalDateTime sendingTime) {
        this.lotId = lotId;
        this.authorId = authorId;
        this.text = text;
        this.sendingTime = sendingTime;
    }

    public LotComment() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotComment that = (LotComment) o;
        return Objects.equals(id, that.id) && Objects.equals(lotId, that.lotId) && Objects.equals(authorId, that.authorId) && Objects.equals(text, that.text) && Objects.equals(sendingTime, that.sendingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, authorId, text, sendingTime);
    }

    @Override
    public String toString() {
        return "LotComment{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", authorId=" + authorId +
                ", text='" + text + '\'' +
                ", sendingTime=" + sendingTime +
                '}';
    }
}

