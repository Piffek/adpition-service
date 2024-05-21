package org.shelter.adoptionservice.application;

import lombok.RequiredArgsConstructor;
import org.shelter.adoptionservice.core.command.AdoptionCommand;
import org.shelter.adoptionservice.core.model.AdoptPetRequest;
import org.shelter.adoptionservice.core.ports.incoming.AdoptPet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pet/adopt")
@RequiredArgsConstructor
public class AdoptPetController {

    private final AdoptPet adoptPet;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    private boolean adopt(@RequestBody AdoptPetRequest adoptPetRequest) {
        return adoptPet.processing(new AdoptionCommand(adoptPetRequest.petId(), adoptPetRequest.userEmail()));
    }
}
