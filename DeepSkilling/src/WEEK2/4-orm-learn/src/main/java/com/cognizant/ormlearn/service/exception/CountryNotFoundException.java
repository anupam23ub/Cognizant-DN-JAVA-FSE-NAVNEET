package com.cognizant.ormlearn.service.exception;

/**
 * Thrown by CountryService.findCountryByCode when no country exists for the
 * supplied code (Doc 1 / Hands-on - findById returns Optional).
 */
public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CountryNotFoundException(String message) {
        super(message);
    }
}
