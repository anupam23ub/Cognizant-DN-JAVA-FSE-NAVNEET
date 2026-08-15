package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Country persistence class (Doc 1 / Hands-on 1).
 *
 * NOTE: the assignment's first snippet maps @Column(name="code"/"name"), but the
 * actual table (Hands-on 5 populate script) uses columns co_code / co_name.
 * The mappings below match the real table so ddl-auto=validate succeeds.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
