package com.example.ws.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Clothes implements Serializable {

    private String color;

    private String size;

}
