package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.models.doctor.*;
import med.voll.api.repository.DoctorRepository;
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
@RequestMapping("doctors")
public class DoctorsController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid MedicalRegisterData data, UriComponentsBuilder uriComponentsBuilder){
        Doctor doctor = new Doctor(data);
        doctorRepository.save(doctor);

        URI uri = uriComponentsBuilder.path("doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetalingData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<MedicalListData>> doctorList (@PageableDefault(size = 10, sort = {"name"}) Pageable pages){
          Page<MedicalListData> page = doctorRepository.findAllByActiveTrue(pages).map(MedicalListData::new);
          return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid MedicalUpdateData data){
        Doctor doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateInformation(data);

        return ResponseEntity.ok(new DoctorDetalingData(doctor));
    }

    //exclusao Logica inativa o medico e nao apaga os dados do banco
    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity deleted(@PathVariable Long id){
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.setInactive();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional  // Colocando transasional funcional pois o spring cuida  do gerenciamento de sessões.
    public ResponseEntity detalingDoctor(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);

        return ResponseEntity.ok(new DoctorDetalingData(doctor));
    }
}
