package med.voll.api.models.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.address.AddressDate;

//RECORD -> PARA PADRAO DTO DATA TRANSFER OBJECT
public record MedicalRegisterData(
        //validacoes dos atributos usando o bean validation

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //significa que o crm sao digitos e sao de 4 a 6 digitos
        String crm,

        @NotNull // o NotBlank serve apenas para strings nesse caso speciality e um enum
        Speciality speciality,

        @NotNull
        @Valid  // aqui AddresDate e outro DTO que precisa de validacao tbm
        AddressDate addressDate
) {
}
