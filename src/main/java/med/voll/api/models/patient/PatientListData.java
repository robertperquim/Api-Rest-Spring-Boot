package med.voll.api.models.patient;

public record PatientListData(Long id, String name, String email, String cpf) {

    public PatientListData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
