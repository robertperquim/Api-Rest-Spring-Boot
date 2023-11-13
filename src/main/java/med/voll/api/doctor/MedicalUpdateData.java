package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDate;

public record MedicalUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressDate addressDate
) {
}
