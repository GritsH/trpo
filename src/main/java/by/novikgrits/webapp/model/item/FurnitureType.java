package by.novikgrits.webapp.model.item;

import java.util.Objects;
import java.util.stream.Stream;

public enum FurnitureType {
    CHAIR ("chair"),
    TABLE("table"),
    BED("bed"),
    CUPBOARD("cupboard"),
    WARDROBE("wardrobe"),
    LAMP("lamp"),
    SOFA("sofa"),
    ARMCHAIR("armchair"),
    OTHER("other");

    private String typeDescription;

    public String getTypeDescription() {
        return typeDescription;
    }

    FurnitureType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public static Stream<FurnitureType> stream() {
        return Stream.of(FurnitureType.values());
    }

    public static FurnitureType getByName(String description) {
        for (FurnitureType value : FurnitureType.values()) {
            if (Objects.equals(value.typeDescription, description)) {
                return value;
            }
        }
        return null;
    }

}
