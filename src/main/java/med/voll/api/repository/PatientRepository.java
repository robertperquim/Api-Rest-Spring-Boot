package med.voll.api.repository;

import med.voll.api.models.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByActiveTrue(Pageable pages);
}
