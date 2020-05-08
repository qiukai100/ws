package com.example.ws.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Clothes implements Serializable {

    @XmlElement
    private String color;

    @XmlElement
    private String size;

}
