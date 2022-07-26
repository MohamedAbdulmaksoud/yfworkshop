package com.yasserfahmy.workshop.data.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "inquiry")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_number", nullable = false)
    private Integer id;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_contact_id", nullable = false)
    private CustomerContact customerContact;

    @Column(name = "customer_rfq", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String customerRfq;

    @OneToMany(mappedBy = "jobNumber")
    private Set<VisualInspection> visualInspections = new LinkedHashSet<>();

    @Enumerated
    @Column(name = "job_category")
    private JobCategory jobCategory;

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerContact getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(CustomerContact customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerRfq() {
        return customerRfq;
    }

    public void setCustomerRfq(String customerRfq) {
        this.customerRfq = customerRfq;
    }

    public Set<VisualInspection> getVisualInspections() {
        return visualInspections;
    }

    public void setVisualInspections(Set<VisualInspection> visualInspections) {
        this.visualInspections = visualInspections;
    }

}