package com.pe.i21722519.cl1_jpa_data_infante_joseph.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countrylanguage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePk countryLanguagePk;
    private String IsOfficial;
    private Double Percentage;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    @MapsId("CountryCode")
    private Country country;

}
