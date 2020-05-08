package com.example.ws.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@XmlRootElement(name = "USER")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    @XmlElement(name = "NAME")
    private String name;

    @XmlElement(name = "AGE")
    private String age;

    @XmlElement(name = "CLOTHES_LIST")
    private List<Clothes> clothesList;
}
