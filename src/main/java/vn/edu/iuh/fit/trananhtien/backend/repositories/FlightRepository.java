package vn.edu.iuh.fit.trananhtien.backend.repositories;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien.backend.models.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query("SELECT f FROM Flight f WHERE f.airplaneName = :airplaneName " +
            "AND (:departureDate BETWEEN f.departureDate AND f.arrivalDate " +
            "OR :arrivalDate BETWEEN f.departureDate AND f.arrivalDate)")
    List<Flight> findConflictingFlights(@Param("airplaneName") String airplaneName,
                                        @Param("departureDate") LocalDate departureDate,
                                        @Param("arrivalDate") LocalDate arrivalDate);

}