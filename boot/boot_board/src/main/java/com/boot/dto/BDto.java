package com.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BDto {
    private int bid;
    private String bname;
    private String btitle;
    private String bcontent;
    private Timestamp bdate;
    private int bhit;


}