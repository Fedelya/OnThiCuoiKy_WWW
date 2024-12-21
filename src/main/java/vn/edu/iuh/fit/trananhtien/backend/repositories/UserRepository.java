package vn.edu.iuh.fit.trananhtien.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.trananhtien.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}