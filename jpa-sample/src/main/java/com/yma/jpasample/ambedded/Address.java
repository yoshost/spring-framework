package com.yma.jpasample.ambedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {

    private String homeNo;
    private String streetNo;

    private String town;
}
