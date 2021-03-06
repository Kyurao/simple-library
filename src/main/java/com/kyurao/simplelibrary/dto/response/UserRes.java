package com.kyurao.simplelibrary.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRes {

    private Long id;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirthday;

    private String email;

    private String phoneNumber;
}
