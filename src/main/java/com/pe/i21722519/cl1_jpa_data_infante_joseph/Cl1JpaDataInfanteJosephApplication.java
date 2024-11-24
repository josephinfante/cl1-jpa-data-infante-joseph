package com.pe.i21722519.cl1_jpa_data_infante_joseph;

import com.pe.i21722519.cl1_jpa_data_infante_joseph.entities.Country;
import com.pe.i21722519.cl1_jpa_data_infante_joseph.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataInfanteJosephApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataInfanteJosephApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/*
		* Pregunta 1
		* */
		Optional<Country> optionalArg = countryRepository.findById("ARG");
		optionalArg.ifPresentOrElse(
				country -> {
					System.out.println("Languages in ARG:");
					country.getLanguages().forEach(lang -> System.out.println(lang.getCountryLanguagePk().getLanguage()));
				},
				() -> {
					System.out.println("ARG not found, fetching PER...");
					Optional<Country> optionalPer = countryRepository.findById("PER");
					optionalPer.ifPresentOrElse(
							country -> {
								System.out.println("Languages in PER:");
								country.getLanguages().forEach(lang -> System.out.println(lang.getCountryLanguagePk().getLanguage()));
							},
							() -> System.out.println("Languages not found.")
					);
				}
		);

		/*
		* Pregunta 2
		* */

		List<String> ids = List.of("ARG", "COL");
		ids.stream().filter(countryRepository::existsById).collect(Collectors.toList());

		if (!ids.isEmpty()) {
			countryRepository.deleteAllById(ids);
		} else {
			System.out.println("IDs not found");
		}
	}
}
