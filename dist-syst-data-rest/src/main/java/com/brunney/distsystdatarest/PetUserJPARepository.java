package com.brunney.distsystdatarest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface PetUserJPARepository extends JpaRepository<PetUser, String> {
}
