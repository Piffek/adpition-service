package org.shelter.adpitionservice.core.ports.outgoing;

import org.shelter.adpitionservice.infra.entity.Adoption;

public interface AdoptionDatabase {
    boolean alreadyAdopted(Long petId);
    void adopt(Adoption adoption);
}
