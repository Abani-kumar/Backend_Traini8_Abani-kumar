package com.Traini8.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.Data;

@Data

@Entity

public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "center name is required")
    @Size(max =40,message =  "Center name must be below 40 characters")
    private String centerName;

    @NotBlank(message = "center code is required")
    @Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be alphanumeric and exactly 12 characters")
    private String centerCode;

    @Valid
    @Embedded
    @NotNull(message = "Address is required")
    private Address address;


    private Integer studentCapacity;

    @ElementCollection
    private List<String> courseOffered;

    @Column(nullable = false)
    private Long createdOn;

    @Email(message = "Please provide a valid email address")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String contactPhone;

    @PrePersist
    protected void onCreate(){
        this.createdOn=System.currentTimeMillis();
    }
}
