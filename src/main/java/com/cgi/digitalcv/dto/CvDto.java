package com.cgi.digitalcv.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CvDto {

    String id;
    @NotEmpty
    String lastName;
    @NotEmpty
    String firstName;

}
