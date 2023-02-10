package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "building_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingCianEntity extends AbstractEntity{
    @Column(name = "main_property_type")
    private String mainPropertyType;
    @Column(name = "main_description")
    private String mainDescription;
    @Column(name = "main_guest_count")
    private Integer mainGuestCount;
    @Column(name = "main_address")
    private String mainAddress;
    @Column(name = "main_coordinates_lat")
    private Double mainCoordinatesLat;
    @Column(name = "main_coordinates_lng")
    private Double mainCoordinatesLng;
    @Column(name = "main_cadastral_number")
    private String mainCadastralNumber;
    @Column(name = "main_phone_schema_country_code")
    private String mainPhoneSchemaCountryCode;
    @Column(name = "main_phone_schema_country_number")
    private String mainPhoneSchemaCountryNumber;
    @Column(name = "main_highway_distance")
    private Double mainHighwayDistance;
    @Column(name = "main_higway_id")
    private Integer mainHigwayId;
    @Column(name = "main_highwayscheam_distace")
    private Double mainHighwayscheamDistace;
    @Column(name = "main_highwayscheam_id")
    private Integer mainHighwayscheamId;
    @Column(name = "main_undegrounds_transport_type")
    private String mainUndegroundsTransportType;
    @Column(name = "main_undegrounds_time")
    private Integer mainUndegroundsTime;
    @Column(name = "main_undegrounds_id")
    private Integer mainUndegroundsId;
    @Column(name = "main_booking_status")
    private String mainBookingStatus;
    @Column(name = "main_subagent_email")
    private String mainSubagentEmail;
    @Column(name = "main_subagent_phone")
    private String mainSubagentPhone;
    @Column(name = "main_subagent_first_name")
    private String mainSubagentFirstName;
    @Column(name = "main_subagent_last_name")
    private String mainSubagentLastName;
    @Column(name = "main_subagent_avatar")
    private String mainSubagentAvatar;
    @Column(name = "main_layoutphoto_url")
    private String mainLayoutphotoUrl;
    @Column(name = "main_layoutphoto_is_default")
    private Boolean mainLayoutphotoIsDefault;
    @Column(name = "main_layoutphoto_photo_type")
    private String mainLayoutphotoPhotoType;
    @Column(name = "main_photos_fullurl")
    private String mainPhotosFullurl;
    @Column(name = "main_photos_is_default")
    private Boolean mainPhotosIsDefault;
    @Column(name = "main_photos_type")
    private String mainPhotosType;
    @Column(name = "main_videos_url")
    private String mainVideosUrl;
    @Column(name = "main_premium_title")
    private String mainPremiumTitle;
    @Column(name = "main_is_rent_by_parts")
    private Boolean mainIsRentByParts;
    @Column(name = "main_rent_by_parts_desc")
    private String mainRentByPartsDesc;
    @Column(name = "main_publish_terms_services")
    private String mainPublishTermsServices;
    @Column(name = "main_publish_terms_excludedservices")
    private String mainPublishTermsExcludedservices;
    @Column(name = "main_publish_terms_ignore")
    private Boolean mainPublishTermsIgnore;
    @Column(name = "main_extra_data_home_owner_name")
    private String mainExtraDataHomeOwnerName;
    @Column(name = "main_extra_data_home_owner_phone")
    private String mainExtraDataHomeOwnerPhone;
    @Column(name = "main_extra_data_exac_addres")
    private String mainExtraDataExacAddres;
    @Column(name = "main_auction_bet")
    private Double mainAuctionBet;
    @Column(name = "category_b")
    private String categoryB;
    @Column(name = "condition_type")
    private String conditionType;
    @Column(name = "layout")
    private String layout;
    @Column(name = "has_furniture")
    private Boolean hasFurniture;
    @Column(name = "input_type")
    private String inputType;
    @Column(name = "available_from")
    private String availableFrom;
    @Column(name = "tax_number")
    private Integer taxNumber;
    @Column(name = "isIn_hidden_base")
    private Boolean isInHiddenBase;
    @Column(name = "bt_contract_type")
    private String btContractType;
    @Column(name = "extinguishing_system_type")
    private String ExtinguishingSystemType;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "building_office_cian",
            foreignKey = @ForeignKey(name = "FK_building_office_cian_office"),
            joinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID"),
            inverseForeignKey = @ForeignKey(name = "FK_building_office_cian_building"),
            inverseJoinColumns = @JoinColumn(name = "office_id", referencedColumnName = "ID")
    )
    private List<OfficeCianEntity> officeEntity;
}