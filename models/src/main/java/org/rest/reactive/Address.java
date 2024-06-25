package org.rest.reactive;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    
    String streetAddress;
        String buildingNumber;
        String city;
        String zipCode;
        String state;
        String country;
}
