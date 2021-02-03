package com.kyurao.simplelibrary.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class UserReq {

    @NotBlank(message = "First name is required")
    protected String firstName;

    @NotBlank(message = "Last name is required")
    protected String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Pattern(regexp = "[0-9]{4}-[01][0-9]-[0-3][0-9]",
            message = "Wrong format of the date of birthday. Use like: 1997-07-23")
    protected LocalDate dateOfBirthday;

    @Email(message = "Wrong format of the email. Use like: somemail@mail.com")
    protected String email;

    @Pattern(regexp = "\\+[0-9]{12}",
            message = "Wrong format of the phone number. Use like: +380930000000")
    protected String phoneNumber;
}
