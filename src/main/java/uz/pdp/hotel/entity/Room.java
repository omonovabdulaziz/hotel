package uz.pdp.hotel.entity;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer number;
    private String floor;
    private long size;
    @ManyToOne
    private Hotel hotel;

}
