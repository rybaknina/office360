package com.senla.office360.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@Table(name = "panoramas")
@NoArgsConstructor
public class Panorama implements Serializable {
    @Id
    private Integer id;
    @NonNull
    @Column(name = "image_panorama")
    private String imagePanorama;
//    private double positionX = 0.00;
//    private double positionY = 0.00;
//    private double positionZ = 0.00;
//    @Column(name = "image_scale")
//    private int imageScale = 300;
//    @NonNull
//    @Column(name = "image_spot")
//    private String imageSpot;

    @OneToMany(mappedBy = "panorama", orphanRemoval = true)
    private Set<Person> persons = new HashSet<>();

//    @OneToMany(mappedBy = "panorama")
//    private Set<PanoramaLink> linksTo;
//
//    //    @ManyToMany
////    private Set<Panorama> linksTo = new HashSet<>();
////
//    @OneToMany(mappedBy="link")
//    private Set<PanoramaLink> linksFrom = new HashSet<>();
}
