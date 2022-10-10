package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Blob;
import java.util.Objects;

public class Item {
    @Id
    private Long id;
    @Column("owner_email")
    private String ownerEmail;
    @Column("photo")
    private Blob photo;
    @Column("brief_info")
    private String briefInfo;

    public Item(String ownerEmail, Blob photo, String briefInfo) {
        this.ownerEmail = ownerEmail;
        this.photo = photo;
        this.briefInfo = briefInfo;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(ownerEmail, item.ownerEmail) && Objects.equals(photo, item.photo) && Objects.equals(briefInfo, item.briefInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerEmail, photo, briefInfo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", photo=" + photo +
                ", briefInfo='" + briefInfo + '\'' +
                '}';
    }
}
