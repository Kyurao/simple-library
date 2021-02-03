package com.kyurao.simplelibrary.domain;

import com.kyurao.simplelibrary.domain.enums.ContactInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String idCard;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirthday;

    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Book> takenBooks = new HashSet<>();
}
