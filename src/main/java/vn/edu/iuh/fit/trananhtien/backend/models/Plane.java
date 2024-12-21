package vn.edu.iuh.fit.trananhtien.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planes")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "plane_name")
    private String planeName;

    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", planeName='" + planeName + '\'' +
                '}';
    }
}