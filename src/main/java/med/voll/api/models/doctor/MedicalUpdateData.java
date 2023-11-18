package med.voll.api.models.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.address.AddressDate;

public record MedicalUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressDate addressDate
) {
}
