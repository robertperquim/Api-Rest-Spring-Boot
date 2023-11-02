package med.voll.api.controller;


import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.MedicalRegisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void register(@RequestBody MedicalRegisterData data){

       doctorRepository.save(new Doctor(data));
    }
}
