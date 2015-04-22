package edu.wctc.spring.boot.rest.demo1.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Just a normal JPA entity class that is mapped to an in-memory H2
 * database table.
 * 
 * @author Jim Lombardo
 */
@Entity
public class Hotel implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String name;
    private String address;
    private String zip;

    protected Hotel() {
    }

    public Hotel(String city, String name, String address, String zip) {
        this.city = city;
        this.name = name;
        this.address = address;
        this.zip = zip;
    }

    public Hotel(Long id, String name, String city, String address, String zip) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.address = address;
        this.zip = zip;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return this.zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", city=" + city + ", name=" + name + ", address=" + address + ", zip=" + zip + '}';
    }

}
