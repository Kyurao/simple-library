package com.kyurao.simplelibray.domain;

import com.kyurao.simplelibray.domain.enums.ContactInfo;
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

    @Column(name = "id_card", unique = true)
    private String idCard;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirthday;

    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Book> takenBooks = new HashSet<>();
}
