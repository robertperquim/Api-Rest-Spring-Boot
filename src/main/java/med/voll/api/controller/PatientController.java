package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.models.patient.*;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("create")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PatientRegisterData data, UriComponentsBuilder uriComponentsBuilder){
        Patient patient = new Patient(data);
        patientRepository.save(patient);

        URI uri = uriComponentsBuilder.path("patient/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetalingData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListData>> patientList (@PageableDefault(size = 10, sort = {"name"}) Pageable pages){
        Page<PatientListData> page = patientRepository.findAllByActiveTrue(pages).map(PatientListData::new);
        return  ResponseEntity.ok(page);
    }

    @PutMapping("update")
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateData data){
        Patient patient = patientRepository.getReferenceById(data.id());
        patient.updateInformations(data);

        return ResponseEntity.ok(new PatientDetalingData(patient));
    }

    //exclusao Logica inativa o paciente e nao apaga os dados do banco
    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity deleted(@PathVariable Long id){
        Patient patient = patientRepository.getReferenceById(id);
        patient.setInactive();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalingPatient(@PathVariable Long id){
        Patient patient = patientRepository.getReferenceById(id);

        return ResponseEntity.ok(new PatientDetalingData(patient));

    }


}
