package med.voll.api.doctor;

//DTO para metodo get

public record MedicalListData(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        Speciality speciality
) {

    public MedicalListData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelephone(), doctor.getCrm(), doctor.getSpeciality());
    }
}
