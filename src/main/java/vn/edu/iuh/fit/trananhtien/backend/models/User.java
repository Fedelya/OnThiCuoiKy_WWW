package vn.edu.iuh.fit.trananhtien.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @ColumnDefault("'0'")
    @Column(name = "password", nullable = false, length = 50)
    private String password;

}