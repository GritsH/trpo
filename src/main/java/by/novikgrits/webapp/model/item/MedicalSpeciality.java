package by.novikgrits.webapp.model.item;

import java.util.Objects;
import java.util.stream.Stream;

public enum MedicalSpeciality {
    DENTISTRY("dentistry"),
    GYNECOLOGY("gynecology"),
    ULTRASOUND("ultrasound"),
    CONTRAST_TOMOGRAPHY("contrast tomography"),
    OPHTHALMOLOGY("ophthalmology"),
    OTHER("other");

    private String typeDescription;

    public String getTypeDescription() {
        return typeDescription;
    }

    MedicalSpeciality(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public static Stream<MedicalSpeciality> stream() {
        return Stream.of(MedicalSpeciality.values());
    }

    public static MedicalSpeciality getByName(String description) {
        for (MedicalSpeciality value : MedicalSpeciality.values()) {
            if (Objects.equals(value.typeDescription, description)) {
                return value;
            }
        }
        return null;
    }
}
