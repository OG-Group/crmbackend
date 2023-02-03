package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "office")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "adr")
    private String adr;
    @Column(name = "cadast")
    private String cadast;
    @Column(name = "taxNum")
    private String taxNum;
    @Column(name = "fullsquare")
    private Double fullsquare;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "maxFloor")
    private Integer maxFloor;
    @Column(name = "isUrAdrPresent")
    private Boolean isUrAdrPresent;
    @Column(name = "roofhigh")
    private Double roofhigh;
    @Column(name = "isTaken")
    private Boolean isTaken;
    @Column(name = "freeDateIfTaken")
    private String freeDateIfTaken;
    @Column(name = "planirovka")
    private String planirovka;
    @Column(name = "valueofwetplace")
    private Integer valueofwetplace;
    @Column(name = "electricityPower")
    private Integer electricityPower;
    @Column(name = "condition")
    private String condition;
    @Column(name = "isPresentMebel")
    private Boolean isPresentMebel;
    @Column(name = "dostup")
    private String dostup;
    @Column(name = "parking")
    private String parking;
    @Column(name = "valueParking")
    private Integer valueParking;
    @Column(name = "priceParking")
    private Integer priceParking;
    @Column(name = "buildingName")
    private String buildingName;
    @Column(name = "builtDate")
    private Integer builtDate;
    @Column(name = "typeOfBuild")
    private String typeOfBuild;
    @Column(name = "classofbuilding")
    private String classofbuilding;
    @Column(name = "square")
    private Double square;
    @Column(name = "uchastokIsMain")
    private Boolean uchastokIsMain;
    @Column(name = "uchastokSize")
    private Double uchastokSize;
    @Column(name = "categoryofbuilding")
    private String categoryofbuilding;
    @Column(name = "developer")
    private String developer;
    @Column(name = "uprCompany")
    private String uprCompany;
    @Column(name = "ventilation")
    private String ventilation;
    @Column(name = "condicioner")
    private String condicioner;
    @Column(name = "otoplenie")
    private String otoplenie;
    @Column(name = "firewall")
    private String firewall;
    @Column(name = "infrastructure")
    private String infrastructure;
    @Column(name = "description")
    private String description;
    @Column(name = "priceType")
    private Integer priceType;
    @Column(name = "price")
    private Integer price;
    @Column(name = "tax")
    private String tax;
    @Column(name = "isCom")
    private Boolean isCom;
    @Column(name = "exsplytacion")
    private Boolean exsplytacion;
    @Column(name = "rentType")
    private String rentType;
    @Column(name = "minRent")
    private Integer minRent;
    @Column(name = "isRentHoolidays")
    private Boolean isRentHoolidays;
    @Column(name = "obespechiteln")
    private Integer obespechiteln;
    @Column(name = "prePay")
    private String prePay;
    @Column(name = "fromStraight")
    private Double fromStraight;
    @Column(name = "fromAnotherAgent")
    private Double fromAnotherAgent;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "office_photo",
            joinColumns = @JoinColumn(name = "office_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "ID")
    )
    private List<PhotoEntity> officePhoto;
}