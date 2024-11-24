package com.pe.i21722519.cl1_jpa_data_infante_joseph.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePk {

    private String CountryCode;
    private String Language;

}
