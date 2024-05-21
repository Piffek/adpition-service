package org.shelter.adoptionservice.infra;

import org.shelter.adoptionservice.infra.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptedPetRepository extends JpaRepository<Adoption, Long> {
}
