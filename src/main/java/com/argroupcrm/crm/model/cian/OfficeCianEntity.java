package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import com.argroupcrm.crm.model.json.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "office_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeCianEntity extends AbstractEntity {
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
    @Column(name = "main_phones_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<PhoneJson> mainPhoneSchemaCountryCode;
    @Column(name = "main_highway_distance")
    private Double mainHighwayDistance;
    @Column(name = "main_higway_id")
    private Integer mainHigwayId;
    @Column(name = "main_highways_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<HighwayJson> mainHighwaySchema;
    @Column(name = "main_undegrounds_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<HighwayJson> mainUndegroundsSchema;
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
    @Column(name = "main_photo_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<PhotosJson> mainPhotoSchema;
    @Column(name = "main_video_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<VideoJson> mainVideoSchema;
    @Column(name = "main_premium_title")
    private String mainPremiumTitle;
    @Column(name = "main_is_rent_by_parts")
    private Boolean mainIsRentByParts;
    @Column(name = "main_rent_by_parts_desc")
    private String mainRentByPartsDesc;
    @Column(name = "main_publisher_terms_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<PublisherTermsJson> mainPublisherTermsSchema;
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
    /*=======================Office info============================================================================================*/
    @Column(name = "category_office")
    private String categoryOffice;
    @Column(name = "total_area")
    private Double totalArea;
    @Column(name = "min_area")
    private Double minArea;
    @Column(name = "floor_number")
    private Integer floorNumber;
    @Column(name = "condition_type")
    private String conditionType;
    @Column(name = "is_occupied")
    private Boolean isOccupied;
    @Column(name = "layout")
    private String layout;
    @Column(name = "furniture_presence")
    private String furniturePresence;
    @Column(name = "available_from")
    private String availableFrom;
    @Column(name = "is_legal_address_provided")
    private Boolean isLegalAddressProvided;
    @Column(name = "water_pipes_count")
    private Integer waterPipesCount;
    @Column(name = "tax_number")
    private Integer taxNumber;
    @Column(name = "is_in_hidden_base")
    private Boolean isInHiddenBase;
    @Column(name = "buisness_shopping_center_id")
    private Integer buisnessShoppingCenterId;
    /*=======================Office building info============================================================================================*/
    @Column(name = "building_name")
    private String buildingName;
    @Column(name = "building_floors_count")
    private Integer buildingFloorsCount;
    @Column(name = "building_build_year")
    private String buildingBuildYear;
    @Column(name = "building_material_type")
    private String buildingMaterialType;
    @Column(name = "building_total_area")
    private Double buildingTotalArea;
    @Column(name = "building_heating_type")
    private String buildingHeatingType;
    @Column(name = "building_ceilling_height")
    private String buildingCellingHeight;
    @Column(name = "building_parking_type")
    private String buildingParkingType;
    @Column(name = "building_parking_places_count")
    private Integer buildingParkingPlacesCount;
    @Column(name = "building_parking_price_monthly")
    private Double buildingParkingPriceMonthly;
    @Column(name = "building_parking_is_free")
    private Boolean buildingParkingIsFree;
    @Column(name = "building_type")
    private String buildingType;
    @Column(name = "building_class_type")
    private String buildingClassType;
    @Column(name = "building_developer")
    private String buildingDeveloper;
    @Column(name = "building_management_company")
    private String buildingManagementCompany;
    @Column(name = "building_ventilation_type")
    private String buildingVentilationType;
    @Column(name = "building_conditioning_type")
    private String buildingConditioningType;
    @Column(name = "building_extinguishing_system_type")
    private String buildingExtinguishingType;
    @Column(name = "building_extinguishing_system_types_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<ExtinguishingSystemTypeJson> buildingExtinguishingSystemTypesSchema;
    @Column(name = "building_access_type")
    private String buildingAccessType;
    @Column(name = "building_infrustructure")
    @Convert(converter = JpaConverterJson.class)
    private List<String> buildingInfrustructure;
    @Column(name = "building_status_type")
    private String buildingStatusType;
    /*=================Office land info=================================================================================*/
    @Column(name = "land_area")
    private Double landArea;
    @Column(name = "land_area_unit_type")
    private String landAreaUnitType;
    @Column(name = "land_area_type")
    private String landAreaType;
    @Column(name = "area_parts_rent_by_parts_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<AreaPartsRentByPartsJson> areaPartsRentByPartsSchema;
    /*=================Office multi listing slots info=================================================================================*/
    @Column(name = "multi_listing_slots_schema")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<MultiListingSlotsJson> multiListingSlotsSchema;
    /*=======================Office bargain terms info============================*/
    @Column(name = "bargain_terms_price")
    private Double bargainTermsPrice;
    @Column(name = "bargain_terms_price_type")
    private String bargainTermsPriceType;
    @Column(name = "bargain_terms_currency")
    private String bargainTermsCurrency;
    @Column(name = "bargain_terms_payment_period")
    private String bargainTermsPaymentPeriod;
    @Column(name = "bargain_terms_vat_type")
    private String bargainTermsVatType;
    @Column(name = "bargain_terms_lease_type")
    private String bargainTermsLeaseType;
    @Column(name = "bargain_terms_include_options_enum")
    @Convert(converter = JpaConverterJson.class)
    private ArrayList<IncludedOptionsEnumJson> bargainTermsIncludeOptionsEnum;
    @Column(name = "bargain_terms_lease_term_type")
    private String bargainTermsLeaseTermType;
    @Column(name = "bargain_terms_lease_min_lease_term")
    private Integer bargainTermsLeaseMinLeaseTerm;
    @Column(name = "bargain_terms_prepay_months")
    private Integer bargainTermsPrepayMonths;
    @Column(name = "bargain_terms_has_grace_period")
    private Boolean bargainTermsHasGracePeriod;
    @Column(name = "bargain_terms_client_fee")
    private Integer bargainTermsClientFee;
    @Column(name = "bargain_terms_security_deposit")
    private Integer bargainTermsSecurityDeposit;
    @Column(name = "bargain_terms_agent_fee")
    private Integer bargainTermsAgentFee;
    @Column(name = "bargain_terms_agent_bonus_value")
    private Double bargainTermsAgentBonusValue;
    @Column(name = "bargain_terms_agent_bonus_payment_type")
    private String bargainTermsAgentBonusPaymentType;
    @Column(name = "bargain_terms_agent_bonus_currency")
    private String bargainTermsAgentBonusCurrency;


}