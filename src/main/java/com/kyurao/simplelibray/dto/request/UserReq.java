package com.kyurao.simplelibray.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserReq {

    protected String firstName;

    protected String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    protected LocalDate dateOfBirthday;

    protected String email;

    protected String phoneNumber;
}
