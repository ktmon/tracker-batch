package com.ktmon.trackerbatch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@Setter
@Builder
public class KeywordParams {
    String query;
    @Max(100)
    Integer display;
    @Max(1000)
    Integer start;
    String sort;
}
