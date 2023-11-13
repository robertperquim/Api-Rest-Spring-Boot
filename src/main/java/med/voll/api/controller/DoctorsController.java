package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.MedicalListData;
import med.voll.api.doctor.MedicalRegisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("doctors")
public class DoctorsController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MedicalRegisterData data){

       doctorRepository.save(new Doctor(data));
    }

    @GetMapping
    public Page<MedicalListData> doctorList (@PageableDefault(size = 10, sort = {"name"}) Pageable pages){
        return doctorRepository.findAll(pages).map(MedicalListData::new);
    }
}
