package by.novikgrits.webapp.model;

import java.sql.Blob;

public class LotPhoto {
    private Integer id;
    private Integer lotId;
    private Blob photo;

    public LotPhoto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
