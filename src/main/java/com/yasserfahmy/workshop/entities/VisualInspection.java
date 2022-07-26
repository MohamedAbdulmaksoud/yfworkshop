package com.yasserfahmy.workshop.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "visual_inspection")
public class VisualInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "line_comment")
    @Type(type = "org.hibernate.type.TextType")
    private String lineComment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_number", nullable = false)
    private Inquiry jobNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "received_by")
    @Type(type = "org.hibernate.type.TextType")
    private String receivedBy;

    @OneToMany(mappedBy = "inspection")
    private Set<DetailedInspection> detailedInspections = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineComment() {
        return lineComment;
    }

    public void setLineComment(String lineComment) {
        this.lineComment = lineComment;
    }

    public Inquiry getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Inquiry jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public Set<DetailedInspection> getDetailedInspections() {
        return detailedInspections;
    }

    public void setDetailedInspections(Set<DetailedInspection> detailedInspections) {
        this.detailedInspections = detailedInspections;
    }

}