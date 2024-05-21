package org.shelter.adoptionservice.core;

import lombok.RequiredArgsConstructor;
import org.shelter.adoptionservice.core.command.AdoptionCommand;
import org.shelter.adoptionservice.infra.AdoptionDatabaseAdapter;
import org.shelter.adoptionservice.infra.entity.Adoption;
import org.shelter.adoptionservice.core.ports.incoming.AdoptPet;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdoptFacade implements AdoptPet {

    private final AdoptionDatabaseAdapter adoptionDatabase;

    @Override
    public boolean processing(AdoptionCommand adoptionCommand) {
        if (!adoptionDatabase.alreadyAdopted(adoptionCommand.petId())) {
            adoptionDatabase.adopt(new Adoption(adoptionCommand.petId(), adoptionCommand.userEmail(), true));
            return true;
        }
        return false;
    }
}
