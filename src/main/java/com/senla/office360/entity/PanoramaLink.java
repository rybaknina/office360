package com.senla.office360.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@Table(name = "panorama_link")
@NoArgsConstructor
public class PanoramaLink {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "panorama_id")
    private int panoramaId;
    @NonNull
    @Column(name = "link_id")
    private int linkId;
    private double positionX = 0.00;
    private double positionY = 0.00;
    private double positionZ = 0.00;
    @Column(name = "image_scale")
    private int imageScale = 300;
    @NonNull
    @Column(name = "image_link")
    private String imageLink;
}
