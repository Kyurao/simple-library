package com.kyurao.simplelibray.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReq {

    private String name;

    private String author;

    private Integer publicationYear;
}
