package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class LotStatus {
    @Id
    private Integer id;
    @Column("status_name")
    private final String lotStatus;

    public LotStatus(String lotStatus) {
        this.lotStatus = lotStatus;
    }

    public Integer getId() {
        return id;
    }

    public String getLotStatus() {
        return lotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotStatus lotStatus1 = (LotStatus) o;
        return Objects.equals(id, lotStatus1.id) && Objects.equals(lotStatus, lotStatus1.lotStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotStatus);
    }

    @Override
    public String toString() {
        return "LotStatus{" +
                "id=" + id +
                ", lotStatus='" + lotStatus + '\'' +
                '}';
    }
}
