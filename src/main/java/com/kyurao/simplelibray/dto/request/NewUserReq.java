package com.kyurao.simplelibray.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewUserReq extends UserReq{

    @NotBlank(message = "Id card is required")
    private String idCard;

}
