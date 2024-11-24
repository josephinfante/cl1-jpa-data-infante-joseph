package com.pe.i21722519.cl1_jpa_data_infante_joseph.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table( name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Double SurfaceArea;
    private Integer IndepYear;
    private Integer Population;
    private Double LifeExpectancy;
    private Double GNP;
    private Double GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private Integer Capital;
    private String Code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CountryLanguage> languages;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<City> cities;

}
