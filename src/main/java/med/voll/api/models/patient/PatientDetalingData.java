package med.voll.api.models.patient;

import med.voll.api.models.address.Adress;

public record PatientDetalingData(Long id, String name, String email, String cpf, String telephone, Adress adress) {

    public PatientDetalingData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getTelephone(), patient.getAdress());
    }
}
