package org.shelter.adoptionservice.core.ports.outgoing;

import org.shelter.adoptionservice.infra.entity.Adoption;

public interface AdoptionDatabase {
    boolean alreadyAdopted(Long petId);
    void adopt(Adoption adoption);
}
