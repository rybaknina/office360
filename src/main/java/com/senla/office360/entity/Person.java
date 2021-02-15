package com.senla.office360.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    private double positionX = 0.00;
    private double positionY = 0.00;
    private double positionZ = 0.00;
    private int pixelX = 0;
    private int pixelY = 0;
    @NonNull
    private String email;
    private String info;
    private String skype;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panorama_id", referencedColumnName = "id", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Panorama panorama;
    private boolean active = true;
}
