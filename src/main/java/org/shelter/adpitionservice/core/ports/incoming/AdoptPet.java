package org.shelter.adpitionservice.core.ports.incoming;

import org.shelter.adpitionservice.core.command.AdoptionCommand;

public interface AdoptPet {
    boolean processing(AdoptionCommand adoptionCommand);
}
