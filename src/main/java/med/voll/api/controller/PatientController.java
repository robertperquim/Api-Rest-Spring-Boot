package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.models.patient.Patient;
import med.voll.api.models.patient.PatientListData;
import med.voll.api.models.patient.PatientRegisterData;
import med.voll.api.models.patient.PatientUpdateData;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("create")
    @Transactional
    public void register(@RequestBody @Valid PatientRegisterData data){

        patientRepository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListData> patientList (@PageableDefault(size = 10, sort = {"name"}) Pageable pages){
        return patientRepository.findAllByActiveTrue(pages).map(PatientListData::new);
    }

    @PutMapping("update")
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdateData data){
        Patient patient = patientRepository.getReferenceById(data.id());
        patient.updateInformations(data);
    }

    //exclusao Logica inativa o paciente e nao apaga os dados do banco
    @DeleteMapping("delete/{id}")
    @Transactional
    public void deleted(@PathVariable Long id){
        Patient patient = patientRepository.getReferenceById(id);
        patient.setInactive();

    }
}
