package com.argroupcrm.crm.model.cian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "office_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeCianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "main_property_type")
    private String mainPropertyType;
    @Basic
    @Column(name = "main_description")
    private String mainDescription;
    @Basic
    @Column(name = "main_guest_count")
    private Integer mainGuestCount;
    @Basic
    @Column(name = "main_address")
    private String mainAddress;
    @Basic
    @Column(name = "main_coordinates_lat")
    private Double mainCoordinatesLat;
    @Basic
    @Column(name = "main_coordinates_lng")
    private Double mainCoordinatesLng;
    @Basic
    @Column(name = "main_cadastral_number")
    private String mainCadastralNumber;
    @Basic
    @Column(name = "main_phone_schema_country_code")
    private String mainPhoneSchemaCountryCode;
    @Basic
    @Column(name = "main_phone_schema_country_number")
    private String mainPhoneSchemaCountryNumber;
    @Basic
    @Column(name = "main_highway_distance")
    private Double mainHighwayDistance;
    @Basic
    @Column(name = "main_higway_id")
    private Integer mainHigwayId;
    @Basic
    @Column(name = "main_highwayscheam_distace")
    private Double mainHighwayscheamDistace;
    @Basic
    @Column(name = "main_highwayscheam_id")
    private Integer mainHighwayscheamId;
    @Basic
    @Column(name = "main_undegrounds_transport_type")
    private String mainUndegroundsTransportType;
    @Basic
    @Column(name = "main_undegrounds_time")
    private Integer mainUndegroundsTime;
    @Basic
    @Column(name = "main_undegrounds_id")
    private Integer mainUndegroundsId;
    @Basic
    @Column(name = "main_booking_status")
    private String mainBookingStatus;
    @Basic
    @Column(name = "main_subagent_email")
    private String mainSubagentEmail;
    @Basic
    @Column(name = "main_subagent_phone")
    private String mainSubagentPhone;
    @Basic
    @Column(name = "main_subagent_first_name")
    private String mainSubagentFirstName;
    @Basic
    @Column(name = "main_subagent_last_name")
    private String mainSubagentLastName;
    @Basic
    @Column(name = "main_subagent_avatar")
    private String mainSubagentAvatar;
    @Basic
    @Column(name = "main_layoutphoto_url")
    private String mainLayoutphotoUrl;
    @Basic
    @Column(name = "main_layoutphoto_is_default")
    private Boolean mainLayoutphotoIsDefault;
    @Basic
    @Column(name = "main_layoutphoto_photo_type")
    private String mainLayoutphotoPhotoType;
    @Basic
    @Column(name = "main_photos_fullurl")
    private String mainPhotosFullurl;
    @Basic
    @Column(name = "main_photos_is_default")
    private Boolean mainPhotosIsDefault;
    @Basic
    @Column(name = "main_photos_type")
    private String mainPhotosType;
    @Basic
    @Column(name = "main_videos_url")
    private String mainVideosUrl;
    @Basic
    @Column(name = "main_premium_title")
    private String mainPremiumTitle;
    @Basic
    @Column(name = "main_is_rent_by_parts")
    private Boolean mainIsRentByParts;
    @Basic
    @Column(name = "main_rent_by_parts_desc")
    private String mainRentByPartsDesc;
    @Basic
    @Column(name = "main_publish_terms_services")
    private String mainPublishTermsServices;
    @Basic
    @Column(name = "main_publish_terms_excludedservices")
    private String mainPublishTermsExcludedservices;
    @Basic
    @Column(name = "main_publish_terms_ignore")
    private Boolean mainPublishTermsIgnore;
    @Basic
    @Column(name = "main_extra_data_home_owner_name")
    private String mainExtraDataHomeOwnerName;
    @Basic
    @Column(name = "main_extra_data_home_owner_phone")
    private String mainExtraDataHomeOwnerPhone;
    @Basic
    @Column(name = "main_extra_data_exac_addres")
    private String mainExtraDataExacAddres;
    @Basic
    @Column(name = "main_auction_bet")
    private Double mainAuctionBet;
    @Basic
    @Column(name = "category_o")
    private String categoryO;
    @Basic
    @Column(name = "tataol_area")
    private Double tataolArea;
    @Basic
    @Column(name = "min_area")
    private Double minArea;
    @Basic
    @Column(name = "floor_num")
    private Integer floorNum;
    @Basic
    @Column(name = "condition_type")
    private String conditionType;
    @Basic
    @Column(name = "is_occuped")
    private Boolean isOccuped;
    @Basic
    @Column(name = "layout")
    private String layout;
    @Basic
    @Column(name = "furniture_presence")
    private String furniturePresence;
    @Basic
    @Column(name = "available_from")
    private String availableFrom;
    @Basic
    @Column(name = "is_legal_address_provided")
    private Boolean isLegalAddressProvided;
    @Basic
    @Column(name = "water_pipes_count")
    private Integer waterPipesCount;
    @Basic
    @Column(name = "tax_number")
    private Integer taxNumber;
    @Basic
    @Column(name = "isln_hidden_base")
    private Boolean islnHiddenBase;
    @Basic
    @Column(name = "buisness_shopping_center_id")
    private Integer buisnessShoppingCenterId;
    @Basic
    @Column(name = "b_name")
    private String bName;
    @Basic
    @Column(name = "b_floors_count")
    private Integer bFloorsCount;
    @Basic
    @Column(name = "b_total_area")
    private Double bTotalArea;
    @Basic
    @Column(name = "b_heating_type")
    private String bHeatingType;
    @Basic
    @Column(name = "b_ceiling_height")
    private Double bCeilingHeight;
    @Basic
    @Column(name = "b_parking_type")
    private String bParkingType;
    @Basic
    @Column(name = "b_parking_places_count")
    private Integer bParkingPlacesCount;
    @Basic
    @Column(name = "b_parking_price_monthly")
    private Double bParkingPriceMonthly;
    @Basic
    @Column(name = "b_parking_is_free")
    private Boolean bParkingIsFree;
    @Basic
    @Column(name = "b_type")
    private String bType;
    @Basic
    @Column(name = "b_house_line")
    private String bHouseLine;
    @Basic
    @Column(name = "b_class_type")
    private String bClassType;
    @Basic
    @Column(name = "b_developer")
    private String bDeveloper;
    @Basic
    @Column(name = "b_management_company")
    private String bManagementCompany;
    @Basic
    @Column(name = "b_ventilation_type")
    private String bVentilationType;
    @Basic
    @Column(name = "b_conditioning_type")
    private String bConditioningType;
    @Basic
    @Column(name = "b_extinguishing_system_type_enum")
    private String bExtinguishingSystemTypeEnum;
    @Basic
    @Column(name = "b_lift_type")
    private String bLiftType;
    @Basic
    @Column(name = "b_lift_additional_type")
    private String bLiftAdditionalType;
    @Basic
    @Column(name = "b_lift_count")
    private Integer bLiftCount;
    @Basic
    @Column(name = "b_status_type")
    private String bStatusType;
    @Basic
    @Column(name = "land_area")
    private Double landArea;
    @Basic
    @Column(name = "land_area_unit_type")
    private String landAreaUnitType;
    @Basic
    @Column(name = "land_type")
    private String landType;
    @Basic
    @Column(name = "area_parts_rent_by_parts_schema_area")
    private Double areaPartsRentByPartsSchemaArea;
    @Basic
    @Column(name = "area_parts_rent_by_parts_schema_price")
    private Double areaPartsRentByPartsSchemaPrice;
    @Basic
    @Column(name = "bt_price")
    private Double btPrice;
    @Basic
    @Column(name = "bt_price_type")
    private String btPriceType;
    @Basic
    @Column(name = "bt_currency")
    private String btCurrency;
    @Basic
    @Column(name = "bt_payment_period")
    private String btPaymentPeriod;
    @Basic
    @Column(name = "bt_val_type")
    private String btValType;
    @Basic
    @Column(name = "bt_lease_type")
    private String btLeaseType;
    @Basic
    @Column(name = "bt_included_options_enum")
    private String btIncludedOptionsEnum;
    @Basic
    @Column(name = "bt_lease_term_type")
    private String btLeaseTermType;
    @Basic
    @Column(name = "bt_min_lease_term")
    private Integer btMinLeaseTerm;
    @Basic
    @Column(name = "bt_prepay_mounths")
    private Integer btPrepayMounths;
    @Basic
    @Column(name = "bt_has_grace_period")
    private Boolean btHasGracePeriod;
    @Basic
    @Column(name = "bt_deposit")
    private Integer btDeposit;
    @Basic
    @Column(name = "bt_client_fee")
    private Integer btClientFee;
    @Basic
    @Column(name = "bt_security_deposit")
    private Integer btSecurityDeposit;
    @Basic
    @Column(name = "bt_agent_fee")
    private Integer btAgentFee;
    @Basic
    @Column(name = "bt_agent_bonus_value")
    private Double btAgentBonusValue;
    @Basic
    @Column(name = "bt_agent_bonus_payment_type")
    private String btAgentBonusPaymentType;
    @Basic
    @Column(name = "bt_agent_bonus_currency")
    private String btAgentBonusCurrency;
    @Basic
    @Column(name = "created_By")
    private String createdBy;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "update_date")
    private Timestamp updateDate;

}