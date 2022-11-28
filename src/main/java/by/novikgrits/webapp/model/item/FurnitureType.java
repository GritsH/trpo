package by.novikgrits.webapp.model.item;

import java.util.ArrayList;
import java.util.List;
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
    public static List<FurnitureType> getAll(){
        List<FurnitureType> types = new ArrayList<>();
        types.add(CHAIR);
        types.add(TABLE);
        types.add(BED);
        types.add(CUPBOARD);
        types.add(WARDROBE);
        types.add(LAMP);
        types.add(SOFA);
        types.add(ARMCHAIR);
        types.add(OTHER);
        return types;
    }

}
