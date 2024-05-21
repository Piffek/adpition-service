package org.shelter.adpitionservice.core.command;

public record AdoptionCommand(Long petId, String userEmail) {
}
