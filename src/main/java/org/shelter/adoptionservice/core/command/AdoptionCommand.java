package org.shelter.adoptionservice.core.command;

public record AdoptionCommand(Long petId, String userEmail) {
}
