package uz.pdp.hotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.entity.Room;
import uz.pdp.hotel.payload.RoomDTO;
import uz.pdp.hotel.repository.HotelRepository;
import uz.pdp.hotel.repository.RoomRepository;

import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    //create
    @PostMapping
    public String addRoom(@RequestBody RoomDTO roomDTO ){
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDTO.getHotelId());
        if (!optionalHotel.isPresent())
            return "bunday id li hotel yoq";

        Hotel hotel = optionalHotel.get();
        Room room = new Room();
        room.setFloor(roomDTO.getFloor());
        room.setSize(roomDTO.getSize());
        room.setHotel(hotel);
        room.setNumber(roomDTO.getNumber());
        roomRepository.save(room);
        return "saved";
    }



    //1-vazifa hotel id orqali shu mexmonxaga tegishli roomlarni royxatini pagable qilib olib keluvchi method yozing
    @GetMapping("/byHotelId/{hotelId}")
    public Page<Room> getRoom(@PathVariable Integer id , @RequestParam int page){
        Pageable pageable  = PageRequest.of(page , 10);
        return roomRepository.findAllByHotelId(id, pageable);

    }
}
