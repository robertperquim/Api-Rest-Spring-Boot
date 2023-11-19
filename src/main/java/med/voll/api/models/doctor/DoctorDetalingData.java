package med.voll.api.models.doctor;

import med.voll.api.models.address.Adress;



public record DoctorDetalingData(Long id, String name, String email, String crm, String telephone, Speciality speciality, Adress adress) {

    public DoctorDetalingData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getTelephone(), doctor.getSpeciality(), doctor.getAdress());
    }

}
