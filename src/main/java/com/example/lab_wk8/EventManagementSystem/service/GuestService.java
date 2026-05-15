package com.example.lab_wk8.EventManagementSystem.service;

import com.example.lab_wk8.EventManagementSystem.enums.GuestStatusEnum;
import com.example.lab_wk8.EventManagementSystem.model.Guest;
import com.example.lab_wk8.EventManagementSystem.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public List<Guest> findGuestByStatus (GuestStatusEnum status) {
        return guestRepository.findGuestByStatus(status);
    }

    public Optional<Guest> findGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update(Long id, Guest guest) {
        var guestToUpdate = findGuestById(id).orElseThrow(
                () -> new RuntimeException("Guest with id " + id + " not found")
        );
        guestToUpdate.setName(guest.getName());
        guestToUpdate.setStatus(guest.getStatus());
        guestToUpdate.setEvent(guest.getEvent());
        return guestRepository.save(guestToUpdate);
    }

    public  void delete(Long id) {
        guestRepository.deleteById(id);
    }
}
