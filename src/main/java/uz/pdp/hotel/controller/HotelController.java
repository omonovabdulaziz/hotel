package uz.pdp.hotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.repository.HotelRepository;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    //CREATE
    @PostMapping
    public String addHotel(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
        return "saved";
    }

    //READ
    @GetMapping
    public List<Hotel> getHotel() {
        return hotelRepository.findAll();
    }
}
