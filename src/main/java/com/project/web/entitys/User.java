package com.project.web.entitys;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = {"userName"}),
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"userImage"})
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "user_image", nullable = true)
    private String userImage;
    @Column(name = "seller", nullable = true)
    private boolean seller;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
     joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Set<Rol> roles = new HashSet<>();
}
