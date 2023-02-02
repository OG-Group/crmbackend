package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "office", schema = "public", catalog = "argroupcrm")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "adr")
    private String adr;
    @Basic
    @Column(name = "cadast")
    private String cadast;
    @Basic
    @Column(name = "taxNum")
    private String taxNum;
    @Basic
    @Column(name = "fullsquare")
    private Double fullsquare;
    @Basic
    @Column(name = "floor")
    private Integer floor;
    @Basic
    @Column(name = "maxFloor")
    private Integer maxFloor;
    @Basic
    @Column(name = "isUrAdrPresent")
    private Boolean isUrAdrPresent;
    @Basic
    @Column(name = "roofhigh")
    private Double roofhigh;
    @Basic
    @Column(name = "isTaken")
    private Boolean isTaken;
    @Basic
    @Column(name = "freeDateIfTaken")
    private String freeDateIfTaken;
    @Basic
    @Column(name = "planirovka")
    private String planirovka;
    @Basic
    @Column(name = "valueofwetplace")
    private Integer valueofwetplace;
    @Basic
    @Column(name = "electricityPower")
    private Integer electricityPower;
    @Basic
    @Column(name = "condition")
    private String condition;
    @Basic
    @Column(name = "isPresentMebel")
    private Boolean isPresentMebel;
    @Basic
    @Column(name = "dostup")
    private String dostup;
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
    @Column(name = "buildingName")
    private String buildingName;
    @Basic
    @Column(name = "builtDate")
    private Integer builtDate;
    @Basic
    @Column(name = "typeOfBuild")
    private String typeOfBuild;
    @Basic
    @Column(name = "classofbuilding")
    private String classofbuilding;
    @Basic
    @Column(name = "square")
    private Double square;
    @Basic
    @Column(name = "uchastokIsMain")
    private Boolean uchastokIsMain;
    @Basic
    @Column(name = "uchastokSize")
    private Double uchastokSize;
    @Basic
    @Column(name = "categoryofbuilding")
    private String categoryofbuilding;
    @Basic
    @Column(name = "developer")
    private String developer;
    @Basic
    @Column(name = "uprCompany")
    private String uprCompany;
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
    @Column(name = "infrastructure")
    private String infrastructure;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "priceType")
    private Integer priceType;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "tax")
    private String tax;
    @Basic
    @Column(name = "isCom")
    private Boolean isCom;
    @Basic
    @Column(name = "exsplytacion")
    private Boolean exsplytacion;
    @Basic
    @Column(name = "rentType")
    private String rentType;
    @Basic
    @Column(name = "minRent")
    private Integer minRent;
    @Basic
    @Column(name = "isRentHoolidays")
    private Boolean isRentHoolidays;
    @Basic
    @Column(name = "obespechiteln")
    private Integer obespechiteln;
    @Basic
    @Column(name = "prePay")
    private String prePay;
    @Basic
    @Column(name = "fromStraight")
    private Double fromStraight;
    @Basic
    @Column(name = "fromAnotherAgent")
    private Double fromAnotherAgent;
    @Basic
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