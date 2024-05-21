package org.shelter.adpitionservice.core;

import lombok.RequiredArgsConstructor;
import org.shelter.adpitionservice.core.command.AdoptionCommand;
import org.shelter.adpitionservice.infra.entity.Adoption;
import org.shelter.adpitionservice.core.ports.incoming.AdoptPet;
import org.shelter.adpitionservice.core.ports.outgoing.AdoptionDatabase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdoptFacade implements AdoptPet {

    private final AdoptionDatabase adoptionDatabase;

    @Override
    public boolean processing(AdoptionCommand adoptionCommand) {
        if (!adoptionDatabase.alreadyAdopted(adoptionCommand.petId())) {
            adoptionDatabase.adopt(new Adoption(adoptionCommand.petId(), adoptionCommand.userEmail(), true));
            return true;
        }
        return false;
    }
}
