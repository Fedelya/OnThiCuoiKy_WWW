package vn.edu.iuh.fit.trananhtien.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien.backend.models.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}