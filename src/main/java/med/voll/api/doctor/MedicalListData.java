package med.voll.api.doctor;

//DTO para metodo get

public record MedicalListData(
        String name,
        String email,
        String telephone,
        String crm,
        Speciality speciality
) {

    public MedicalListData(Doctor doctor){
        this(doctor.getName(), doctor.getEmail(), doctor.getTelephone(), doctor.getCrm(), doctor.getSpeciality());
    }
}
