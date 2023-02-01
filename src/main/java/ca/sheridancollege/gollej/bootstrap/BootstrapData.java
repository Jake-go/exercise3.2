package ca.sheridancollege.gollej.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.gollej.beans.Guest;
import ca.sheridancollege.gollej.beans.Pet;
import ca.sheridancollege.gollej.repositories.GuestRepository;
import ca.sheridancollege.gollej.repositories.PetRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private GuestRepository guestRepo;
    private PetRepository petRepo;

    @Override
    public void run(String... args) throws Exception {
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        pet1.setSpecies("Dog");
        petRepo.save(pet1);

        Guest guest1 = new Guest(0l, "John", 25, pet1);
        guestRepo.save(guest1);

        Guest guest2 = new Guest();
        guest2.setName("Jane");
        guest2.setAge(30);
        guest2 = guestRepo.save(guest2);

    }

}
