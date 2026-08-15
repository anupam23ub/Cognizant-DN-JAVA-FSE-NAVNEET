package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * CountryService (Doc 1 - CRUD; Doc 2 / Hands-on 1 - query methods).
 * All methods are @Transactional as required by the assignment.
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Doc 1 / Hands-on: get all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Doc 1 / Hands-on: find one country by code, throwing if absent
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (result.isEmpty()) {
            throw new CountryNotFoundException("Country not found: " + countryCode);
        }
        return result.get();
    }

    // Doc 1 / Hands-on: add a new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Doc 1 / Hands-on: update an existing country's name
    @Transactional
    public void updateCountry(String countryCode, String name) throws CountryNotFoundException {
        Country country = findCountryByCode(countryCode);
        country.setName(name);
        countryRepository.save(country);
    }

    // Doc 1 / Hands-on: delete a country by code
    @Transactional
    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

    // Doc 2 / Hands-on 1: query-method passthroughs
    @Transactional
    public List<Country> searchCountries(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional
    public List<Country> searchCountriesSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional
    public List<Country> findCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
