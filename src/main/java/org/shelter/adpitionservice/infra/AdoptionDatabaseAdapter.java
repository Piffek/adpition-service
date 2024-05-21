package org.shelter.adpitionservice.infra;

import lombok.RequiredArgsConstructor;
import org.shelter.adpitionservice.infra.entity.Adoption;
import org.shelter.adpitionservice.core.ports.outgoing.AdoptionDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdoptionDatabaseAdapter implements AdoptionDatabase {

    private final AdoptionRepository adoptionRepository;

    @Override
    public boolean alreadyAdopted(Long petId) {
        var adoption = adoptionRepository.findById(petId);
        return adoption.map(Adoption::isIsAlreadyAdopted).orElse(false);

    }

    @Override
    public void adopt(Adoption adoption) {
        adoptionRepository.save(adoption);
    }

    private interface AdoptionRepository extends JpaRepository<Adoption, Long> {

    }
}
