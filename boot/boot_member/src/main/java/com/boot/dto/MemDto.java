package com.boot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemDto {

    private String mem_uid;
    private String mem_pwd;
    private String mem_name;
}
