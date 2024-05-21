package org.shelter.adoptionservice.core.ports.outgoing;

import java.util.List;

public interface FindAdoptedPet {
    List<Long> find();
}
