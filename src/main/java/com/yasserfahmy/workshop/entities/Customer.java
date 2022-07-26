package com.yasserfahmy.workshop.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "customer_code")
    @Type(type = "org.hibernate.type.TextType")
    private String customerCode;

    @Column(name = "name", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "phone")
    @Type(type = "org.hibernate.type.TextType")
    private String phone;

    @Column(name = "street")
    @Type(type = "org.hibernate.type.TextType")
    private String street;

    @Column(name = "city")
    @Type(type = "org.hibernate.type.TextType")
    private String city;

    @Column(name = "vat_number")
    @Type(type = "org.hibernate.type.TextType")
    private String vatNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Inquiry> inquiries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<CustomerContact> customerContacts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public Set<Inquiry> getInquiries() {
        return inquiries;
    }

    public void setInquiries(Set<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }

    public Set<CustomerContact> getCustomerContacts() {
        return customerContacts;
    }

    public void setCustomerContacts(Set<CustomerContact> customerContacts) {
        this.customerContacts = customerContacts;
    }

}