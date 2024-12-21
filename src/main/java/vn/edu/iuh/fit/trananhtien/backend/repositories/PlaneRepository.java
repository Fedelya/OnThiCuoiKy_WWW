package vn.edu.iuh.fit.trananhtien.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien.backend.models.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}