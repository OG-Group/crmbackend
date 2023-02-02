package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "building", schema = "public", catalog = "argroupcrm")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BuildingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "cadastrNum")
    private String cadastrNum;
    @Basic
    @Column(name = "taxNum")
    private String taxNum;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "yearOfBuilt")
    private Integer yearOfBuilt;
    @Basic
    @Column(name = "square")
    private Double square;
    @Basic
    @Column(name = "maxFloor")
    private Integer maxFloor;
    @Basic
    @Column(name = "roofHigh")
    private Double roofHigh;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "condition")
    private String condition;
    @Basic
    @Column(name = "isMebelPresent")
    private Boolean isMebelPresent;
    @Basic
    @Column(name = "lineOfHouses")
    private String lineOfHouses;
    @Basic
    @Column(name = "isMainUchastok")
    private Boolean isMainUchastok;
    @Basic
    @Column(name = "uchastokSize")
    private Double uchastokSize;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "developer")
    private String developer;
    @Basic
    @Column(name = "masterCompany")
    private String masterCompany;
    @Basic
    @Column(name = "ventilation")
    private String ventilation;
    @Basic
    @Column(name = "condicioner")
    private String condicioner;
    @Basic
    @Column(name = "otoplenie")
    private String otoplenie;
    @Basic
    @Column(name = "firewall")
    private String firewall;
    @Basic
    @Column(name = "elevators")
    private Integer elevators;
    @Basic
    @Column(name = "traveler")
    private Integer traveler;
    @Basic
    @Column(name = "excavators")
    private Integer excavators;
    @Basic
    @Column(name = "entrance")
    private String entrance;
    @Basic
    @Column(name = "parking")
    private String parking;
    @Basic
    @Column(name = "valueParking")
    private Integer valueParking;
    @Basic
    @Column(name = "priceParking")
    private Integer priceParking;
    @Basic
    @Column(name = "isMounthlyPrice")
    private Boolean isMounthlyPrice;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "tax")
    private String tax;
    @Basic
    @Column(name = "isComm")
    private Boolean isComm;
    @Basic
    @Column(name = "isExsplytacion")
    private Boolean isExsplytacion;
    @Basic
    @Column(name = "isArendaStraight")
    private Boolean isArendaStraight;
    @Basic
    @Column(name = "minRent")
    private String minRent;
    @Basic
    @Column(name = "isRestForRentPresent")
    private Boolean isRestForRentPresent;
    @Basic
    @Column(name = "obespechitelniiPlat")
    private Integer obespechitelniiPlat;
    @Basic
    @Column(name = "beforePay")
    private String beforePay;
    @Basic
    @Column(name = "fromStraight")
    private Double fromStraight;
    @Basic
    @Column(name = "fromAnotheragent")
    private Double fromAnotheragent;
    @Basic
    @Column(name = "phone")
    private Integer phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "building_highway",
            joinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "highway_id", referencedColumnName = "ID")
    )
    private List<HighwayEntity> buildingHighway;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "building_metro",
            joinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "metro_id", referencedColumnName = "ID")
    )
    private List<MetroEntity> buildingMetro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "building_photo",
            joinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "ID")
    )
    private List<PhotoEntity> buildingPhoto;
}
