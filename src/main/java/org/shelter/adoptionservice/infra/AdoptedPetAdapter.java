package org.shelter.adoptionservice.infra;

import lombok.RequiredArgsConstructor;
import org.shelter.adoptionservice.core.ports.outgoing.FindAdoptedPet;
import org.shelter.adoptionservice.infra.entity.Adoption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdoptedPetAdapter implements FindAdoptedPet {
    private final AdoptedPetRepository adoptedPetRepository;

    @Override
    public List<Long> find() {
        return adoptedPetRepository.findAll()
                .stream().filter(Adoption::isAlreadyAdopted)
                .map(Adoption::getPetId)
                .toList();
    }
}
