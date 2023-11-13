package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDate(

        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String uf,

        String number,
        String complement

) {
}
