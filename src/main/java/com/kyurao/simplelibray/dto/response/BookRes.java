package com.kyurao.simplelibray.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRes {

    private String name;

    private String author;

    private Integer publicationYear;
}
