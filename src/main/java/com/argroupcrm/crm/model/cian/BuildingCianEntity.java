package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.model.oldtemplate.MetroEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "building_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingCianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
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
    @Column(name = "b_name")
    private String bName;
    @Column(name = "b_floors_count")
    private Integer bFloorsCount;
    @Column(name = "b_total_area")
    private Double bTotalArea;
    @Column(name = "b_heating_type")
    private String bHeatingType;
    @Column(name = "b_ceiling_height")
    private Double bCeilingHeight;
    @Column(name = "b_parking_type")
    private String bParkingType;
    @Column(name = "b_parking_places_count")
    private Integer bParkingPlacesCount;
    @Column(name = "b_parking_price_monthly")
    private Double bParkingPriceMonthly;
    @Column(name = "b_parking_is_free")
    private Boolean bParkingIsFree;
    @Column(name = "b_type")
    private String bType;
    @Column(name = "b_house_line")
    private String bHouseLine;
    @Column(name = "b_class_type")
    private String bClassType;
    @Column(name = "b_developer")
    private String bDeveloper;
    @Column(name = "b_management_company")
    private String bManagementCompany;
    @Column(name = "b_ventilation_type")
    private String bVentilationType;
    @Column(name = "b_conditioning_type")
    private String bConditioningType;
    @Column(name = "b_extinguishing_system_type_enum")
    private String bExtinguishingSystemTypeEnum;
    @Column(name = "b_lift_type")
    private String bLiftType;
    @Column(name = "b_lift_additional_type")
    private String bLiftAdditionalType;
    @Column(name = "b_lift_count")
    private Integer bLiftCount;
    @Column(name = "b_status_type")
    private String bStatusType;
    @Column(name = "land_area")
    private Double landArea;
    @Column(name = "land_area_unit_type")
    private String landAreaUnitType;
    @Column(name = "land_type")
    private String landType;
    @Column(name = "area_parts_rent_by_parts_schema_area")
    private Double areaPartsRentByPartsSchemaArea;
    @Column(name = "area_parts_rent_by_parts_schema_price")
    private Double areaPartsRentByPartsSchemaPrice;
    @Column(name = "bt_price")
    private Double btPrice;
    @Column(name = "bt_price_type")
    private String btPriceType;
    @Column(name = "bt_currency")
    private String btCurrency;
    @Column(name = "bt_payment_period")
    private String btPaymentPeriod;
    @Column(name = "bt_val_type")
    private String btValType;
    @Column(name = "bt_lease_type")
    private String btLeaseType;
    @Column(name = "bt_included_options_enum")
    private String btIncludedOptionsEnum;
    @Column(name = "bt_lease_term_type")
    private String btLeaseTermType;
    @Column(name = "bt_min_lease_term")
    private Integer btMinLeaseTerm;
    @Column(name = "bt_prepay_mounths")
    private Integer btPrepayMounths;
    @Column(name = "bt_has_grace_period")
    private Boolean btHasGracePeriod;
    @Column(name = "bt_deposit")
    private Integer btDeposit;
    @Column(name = "bt_client_fee")
    private Integer btClientFee;
    @Column(name = "bt_security_deposit")
    private Integer btSecurityDeposit;
    @Column(name = "bt_agent_fee")
    private Integer btAgentFee;
    @Column(name = "bt_agent_bonus_value")
    private Double btAgentBonusValue;
    @Column(name = "bt_agent_bonus_payment_type")
    private String btAgentBonusPaymentType;
    @Column(name = "bt_agent_bonus_currency")
    private String btAgentBonusCurrency;
    @Column(name = "created_By")
    private String createdBy;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "update_date")
    private Timestamp updateDate;
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