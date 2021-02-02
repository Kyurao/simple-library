package com.kyurao.simplelibray.domain;


import com.kyurao.simplelibray.domain.enums.BookState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String author;

    private Integer publicationYear;

    @Enumerated(EnumType.STRING)
    private BookState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User client;
}
