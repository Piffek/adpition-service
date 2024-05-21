package org.shelter.adoptionservice.core.ports.incoming;

import org.shelter.adoptionservice.core.command.AdoptionCommand;

public interface AdoptPet {
    boolean processing(AdoptionCommand adoptionCommand);
}
