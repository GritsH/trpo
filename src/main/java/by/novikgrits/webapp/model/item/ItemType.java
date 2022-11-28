package by.novikgrits.webapp.model.item;

import java.util.Objects;
import java.util.stream.Stream;

public enum ItemType {
    CAR("car"),
    REAL_ESTATE("real estate"),
    JEWELRY("jewelry"),
    CLOTHES("clothes"),
    FURNITURE("furniture"),
    BUILDING_EQUIPMENT("building equipment"),
    SPORT_EQUIPMENT("sport equipment"),
    MEDICAL_EQUIPMENT("medical equipment"),
    OTHER("other");

    private String typeDescription;

    public String getTypeDescription() {
        return typeDescription;
    }

    ItemType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public static Stream<ItemType> stream() {
        return Stream.of(ItemType.values());
    }

    public static ItemType getByName(String description) {
        for (ItemType value : ItemType.values()) {
            if (Objects.equals(value.typeDescription, description)) {
                return value;
            }
        }
        return null;
    }
}
