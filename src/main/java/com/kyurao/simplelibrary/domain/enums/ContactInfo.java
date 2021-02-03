package com.kyurao.simplelibrary.domain.enums;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Getter
@Setter
@Embeddable
public class ContactInfo {

    @Email
    private String email;

    private String phoneNumber;
}
