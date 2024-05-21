package org.shelter.adpitionservice.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Adoption")
@Table(name = "Adoption")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long petId;
    private String userEmail;
    private boolean isAlreadyAdopted;

    public Adoption(Long petId, String userEmail, boolean alreadyAdopted) {
        this.petId = petId;
        this.userEmail = userEmail;
        this.isAlreadyAdopted = alreadyAdopted;
    }

    // for JPA only, no use
    public Adoption() {
    }
}

