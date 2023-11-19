package med.voll.api.models.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.address.AddressDate;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressDate addressDate
) {
}
