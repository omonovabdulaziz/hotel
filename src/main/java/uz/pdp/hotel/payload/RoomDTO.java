package uz.pdp.hotel.payload;


import lombok.Data;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.repository.HotelRepository;

@Data

public class RoomDTO {
    private Integer number;
    private String floor;
    private long size;
    private Integer hotelId;
}
