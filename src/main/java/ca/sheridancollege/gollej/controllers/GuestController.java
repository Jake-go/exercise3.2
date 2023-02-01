package ca.sheridancollege.gollej.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.gollej.beans.Guest;
import ca.sheridancollege.gollej.beans.Pet;
import ca.sheridancollege.gollej.repositories.GuestRepository;
import ca.sheridancollege.gollej.repositories.PetRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GuestController {

    private GuestRepository guestRepo;
    private PetRepository petRepo;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    // Navigate to the addGuest.html page
    @GetMapping("/addGuest")
    public String addGuest() {
        return "addGuest.html";
    }

    // Process add guest form
    @GetMapping("/processAddGuest")
    public String processAddGuest(@RequestParam String name, @RequestParam Integer age, @RequestParam String petName,
            @RequestParam String petSpecies) {

        if (!petName.equals("") && !petSpecies.equals("")) {
            Pet newPet = new Pet();
            newPet.setName(petName);
            newPet.setSpecies(petSpecies);
            newPet = petRepo.save(newPet);

            Guest newGuest = new Guest();
            newGuest.setName(name);
            newGuest.setAge(age);
            newGuest.setPet(newPet);
            guestRepo.save(newGuest);
        } else {
            Guest newGuest = new Guest();
            newGuest.setName(name);
            newGuest.setAge(age);
            guestRepo.save(newGuest);
        }

        return "redirect:/viewGuests";
    }

    // Navigate to the viewGuests.html page, provide model for the table
    @GetMapping("/viewGuests")
    public String viewGuests(Model model) {
        model.addAttribute("guests", guestRepo.findAll());
        return "viewGuests.html";
    }

}
