package med.voll.api.doctor;

import med.voll.api.address.AddressDate;

//RECORD -> PARA PADRAO DTO DATA TRANSFER OBJECT
public record MedicalRegisterData(String name, String email, String crm, Speciality speciality, AddressDate addressDate ) {
}
