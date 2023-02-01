package ca.sheridancollege.gollej.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ca.sheridancollege.gollej.beans.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
