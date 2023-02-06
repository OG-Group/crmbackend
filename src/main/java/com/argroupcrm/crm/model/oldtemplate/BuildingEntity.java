package com.argroupcrm.crm.model.oldtemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "building")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BuildingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "adr")
    private String adr;
    @Column(name = "cadastrNum")
    private String cadastrNum;
    @Column(name = "taxNum")
    private String taxNum;

    @Column(name = "nameB")
    private String nameB;
    @Column(name = "yearOfBuilt")
    private Integer yearOfBuilt;
    @Column(name = "square")
    private Double square;
    @Column(name = "maxFloor")
    private Integer maxFloor;

    @Column(name = "roofHigh")
    private Double roofHigh;
    @Column(name = "typeB")
    private String typeB;
    @Column(name = "condition")
    private String condition;
    @Column(name = "isMebelPresent")
    private Boolean isMebelPresent;
    @Column(name = "lineOfHouses")
    private String lineOfHouses;
    @Column(name = "isMainUchastok")
    private Boolean isMainUchastok;
    @Column(name = "uchastokSize")
    private Double uchastokSize;
    @Column(name = "categoryBuilding")
    private String categoryBuilding;
    @Column(name = "developer")
    private String developer;
    @Column(name = "masterCompany")
    private String masterCompany;
    @Column(name = "ventilation")
    private String ventilation;
    @Column(name = "condicioner")
    private String condicioner;
    @Column(name = "otoplenie")
    private String otoplenie;
    @Column(name = "firewall")
    private String firewall;
    @Column(name = "elevators")
    private Integer elevators;
    @Column(name = "traveler")
    private Integer traveler;
    @Column(name = "excavators")
    private Integer excavators;
    @Column(name = "entrance")
    private String entrance;
    @Column(name = "parking")
    private String parking;
    @Column(name = "valueParking")
    private Integer valueParking;
    @Column(name = "priceParking")
    private Integer priceParking;
    @Column(name = "isMounthlyPrice")
    private Boolean isMounthlyPrice;
    @Column(name = "price")
    private Double price;
    @Column(name = "tax")
    private String tax;
    @Column(name = "isComm")
    private Boolean isComm;
    @Column(name = "isExsplytacion")
    private Boolean isExsplytacion;
    @Column(name = "isArendaStraight")
    private Boolean isArendaStraight;
    @Column(name = "minRent")
    private String minRent;
    @Column(name = "isRestForRentPresent")
    private Boolean isRestForRentPresent;
    @Column(name = "obespechitelniiPlat")
    private Integer obespechitelniiPlat;
    @Column(name = "beforePay")
    private String beforePay;
    @Column(name = "fromStraight")
    private Double fromStraight;
    @Column(name = "fromAnotheragent")
    private Double fromAnotheragent;
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
