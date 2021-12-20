package com.foot.poc.model;


import com.foot.poc.utils.UserRole;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private LocalDate birthday;
    private String address;
    private String phoneNumber;

    private Boolean locked = false;
    private Boolean enabled = false;

    public User(String userName,
                String email,
                String password,
                UserRole userRole,
                LocalDate birthday,
                String address,
                String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
