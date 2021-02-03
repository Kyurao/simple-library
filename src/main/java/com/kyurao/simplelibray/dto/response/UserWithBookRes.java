package com.kyurao.simplelibray.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithBookRes {

    private Long userId;

    private String firstName;

    private String lastName;

    private List<BookRes> userBooks;
}
