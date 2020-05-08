package com.example.ws.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private String name;

    private String age;

    private List<Clothes> clothesList;
}
