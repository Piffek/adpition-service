package org.shelter.adpitionservice.infra;

import lombok.RequiredArgsConstructor;
import org.shelter.adpitionservice.core.ports.outgoing.FindAdoptedPet;
import org.shelter.adpitionservice.infra.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
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


    private interface AdoptedPetRepository extends JpaRepository<Adoption, Long> {

    }
}
