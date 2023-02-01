package ca.sheridancollege.gollej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.gollej.beans.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{
	
}
