package vn.edu.iuh.fit.trananhtien.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.iuh.fit.trananhtien.backend.enums.FlightStatus;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "airplane_name")
    private String airplaneName;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate arrivalDate;

    @Column(name = "seat_fare")
    private Double seatFare;

    @Column(name = "flight_status")
    private FlightStatus flightStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Plane plane;

}