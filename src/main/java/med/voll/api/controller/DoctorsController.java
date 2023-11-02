package med.voll.api.controller;


import med.voll.api.doctor.MedicalRegisterData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorsController {

    @PostMapping
    public void register(@RequestBody MedicalRegisterData data){
        System.out.println(data);
    }
}
