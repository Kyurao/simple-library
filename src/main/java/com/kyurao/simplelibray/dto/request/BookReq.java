package com.kyurao.simplelibray.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class BookReq {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Author is required")
    private String author;

    @NotNull(message = "Publication Year is required")
    @Min(value = 0, message = "Year cannot be less than 0")
    @Max(value = 3000, message = "Book with publication year more than 3000 is not allowed")
    @Pattern(regexp = "[0-9]{1,4}", message = "Wrong format of the year. Use like: 1990")
    private Integer publicationYear;
}
