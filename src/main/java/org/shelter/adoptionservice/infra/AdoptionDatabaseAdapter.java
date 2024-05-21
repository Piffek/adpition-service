package org.shelter.adoptionservice.infra;

import lombok.RequiredArgsConstructor;
import org.shelter.adoptionservice.infra.entity.Adoption;
import org.shelter.adoptionservice.core.ports.outgoing.AdoptionDatabase;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdoptionDatabaseAdapter implements AdoptionDatabase {
    private final AdoptionRepository adoptionRepository;

    @Override
    public boolean alreadyAdopted(Long petId) {
        var adoption = adoptionRepository.findById(petId);
        return adoption.map(Adoption::isAlreadyAdopted).orElse(false);

    }

    @Override
    public void adopt(Adoption adoption) {
        adoptionRepository.save(adoption);
    }
}
