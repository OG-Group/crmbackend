package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.model.json.*;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "building_cian", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class BuildingCianEntity extends AbstractEntity {
    @Column(name = "main_property_type")
    private String mainPropertyType;
    @Column(name = "main_description")
    private String mainDescription;
    @Column(name = "main_guest_count")
    private String mainGuestCount;
    @Column(name = "main_address")
    private String mainAddress;
    @Column(name = "main_coordinates_lat")
    private String mainCoordinatesLat;
    @Column(name = "main_coordinates_lng")
    private String mainCoordinatesLng;
    @Column(name = "main_cadastral_number")
    private String mainCadastralNumber;
    @Type(type = "jsonb")
    @Column(name = "main_phones_schema", columnDefinition = "jsonb")
    private List<PhoneJson> mainPhonesSchema;
    @Column(name = "main_highway_distance")
    private String mainHighwayDistance;
    @Column(name = "main_higway_id")
    private String mainHigwayId;
    @Type(type = "jsonb")
    @Column(name = "main_highways_schema", columnDefinition = "jsonb")
    private List<HighwayJson> mainHighwaySchema;
    @Type(type = "jsonb")
    @Column(name = "main_undegrounds_schema", columnDefinition = "jsonb")
    private List<UndegroundJson> mainUndegroundsSchema;
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
    @Type(type = "jsonb")
    @Column(name = "main_photo_schema", columnDefinition = "jsonb")
    private List<PhotosJson> mainPhotoSchema;
    @Type(type = "jsonb")
    @Column(name = "main_video_schema", columnDefinition = "jsonb")
    private List<VideoJson> mainVideoSchema;
    @Column(name = "main_premium_title")
    private String mainPremiumTitle;
    @Column(name = "main_is_rent_by_parts")
    private Boolean mainIsRentByParts;
    @Column(name = "main_rent_by_parts_desc")
    private String mainRentByPartsDesc;
    @Column(name = "main_publish_terms_ignore")
    private Boolean mainPublishTermsIgnore;
    @Type(type = "jsonb")
    @Column(name = "main_publisher_terms_schema_services", columnDefinition = "jsonb")
    private List<PublisherTermsSchemaServicesJson> mainJsonPublisherTermsSchemaServices;
    @Type(type = "jsonb")
    @Column(name = "main_publisher_terms_schema_excluded_services", columnDefinition = "jsonb")
    private List<PublisherTermsSchemaExcludedServicesJson> mainJsonPublisherTermsSchemaExcludedServices;
    @Column(name = "main_extra_data_home_owner_name")
    private String mainExtraDataHomeOwnerName;
    @Column(name = "main_extra_data_home_owner_phone")
    private String mainExtraDataHomeOwnerPhone;
    @Column(name = "main_extra_data_exac_addres")
    private String mainExtraDataExacAddres;
    @Column(name = "main_auction_bet")
    private String mainAuctionBet;
    /*=================Building info=================================================================================*/
    @Column(name = "category_bulding")
    private String categoryBuilding;
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
    private String taxNumber;
    @Column(name = "is_in_hidden_base")
    private Boolean isInHiddenBase;
    @Column(name = "title")
    private String title;
    /*=================Building building info=================================================================================*/
    @Column(name = "building_name")
    private String buildingName;
    @Column(name = "building_build_year")
    private String buildingBuildYear;
    @Column(name = "building_material_type")
    private String buildingMaterialType;
    @Column(name = "building_floors_count")
    private String buildingFloorsCount;
    @Column(name = "building_total_area")
    private String buildingTotalArea;
    @Column(name = "building_heating_type")
    private String buildingHeatingType;
    @Column(name = "building_ceilling_height")
    private String buildingCellingHeight;
    @Column(name = "building_parking_type")
    private String buildingParkingType;
    @Column(name = "building_parking_places_count")
    private String buildingParkingPlacesCount;
    @Column(name = "building_parking_price_monthly")
    private String buildingParkingPriceMonthly;
    @Column(name = "building_parking_is_free")
    private Boolean buildingParkingIsFree;
    @Column(name = "building_type")
    private String buildingType;
    @Column(name = "building_house_line_type")
    private String buildingHouseLineType;
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
    @Type(type = "jsonb")
    @Column(name = "building_extinguishing_system_types_schema", columnDefinition = "jsonb")
    private List<ExtinguishingSystemTypeJson> buildingExtinguishingSystemTypesSchema;
    @Type(type = "jsonb")
    @Column(name = "building_lift_types_schema", columnDefinition = "jsonb")
    private List<LiftTypeJson> buildingLiftTypesSchema;
    @Type(type = "jsonb")
    @Column(name = "building_infrustructure", columnDefinition = "jsonb")
    private List<String> buildingInfrustructure;
    @Column(name = "building_access_type")
    private String buildingAccessType;
    @Column(name = "building_status_type")
    private String buildingStatusType;
    /*=================Building land info=================================================================================*/
    @Column(name = "land_area")
    private String landArea;
    @Column(name = "land_area_unit_type")
    private String landAreaUnitType;
    @Column(name = "land_area_type")
    private String landAreaType;
    @Type(type = "jsonb")
    @Column(name = "area_parts_rent_by_parts_schema", columnDefinition = "jsonb")
    private List<AreaPartsRentByPartsJson> areaPartsRentByPartsSchema;
    /*=================Building multi listing slots info=================================================================================*/
    @Type(type = "jsonb")
    @Column(name = "multi_listing_slots_schema", columnDefinition = "jsonb")
    private List<MultiListingSlotsJson> multiListingSlotsSchema;
    /*=================Building bargain terms info=================================================================================*/
    @Column(name = "bargain_terms_price")
    private String bargainTermsPrice;
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
    @Type(type = "jsonb")
    @Column(name = "bargain_terms_include_options_enum", columnDefinition = "jsonb")
    private List<IncludedOptionsEnumJson> bargainTermsIncludeOptionsEnum;
    @Column(name = "bargain_terms_lease_term_type")
    private String bargainTermsLeaseTermType;
    @Column(name = "bargain_terms_lease_min_lease_term")
    private String bargainTermsLeaseMinLeaseTerm;
    @Column(name = "bargain_terms_prepay_months")
    private String bargainTermsPrepayMonths;
    @Column(name = "bargain_terms_has_grace_period")
    private Boolean bargainTermsHasGracePeriod;
    @Column(name = "bargain_terms_deposit")
    private String bargainTermsDeposit;
    @Column(name = "bargain_terms_client_fee")
    private String bargainTermsClientFee;
    @Column(name = "bargain_terms_security_deposit")
    private String bargainTermsSecurityDeposit;
    @Column(name = "bargain_terms_agent_fee")
    private String bargainTermsAgentFee;
    @Column(name = "bargain_terms_agent_bonus_value")
    private String bargainTermsAgentBonusValue;
    @Column(name = "bargain_terms_agent_bonus_payment_type")
    private String bargainTermsAgentBonusPaymentType;
    @Column(name = "bargain_terms_agent_bonus_currency")
    private String bargainTermsAgentBonusCurrency;

    /*=================Linked Office info=================================================================================*/
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "building_office_cian",
//            foreignKey = @ForeignKey(name = "FK_building_office_cian_office"),
//            joinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID"),
//            inverseForeignKey = @ForeignKey(name = "FK_building_office_cian_building"),
//            inverseJoinColumns = @JoinColumn(name = "office_id", referencedColumnName = "ID")
//    )
//    private List<OfficeCianEntity> officeEntity;
    /*=================Building service info=================================================================================*/
    @Column(name = "service_information_save_on_cian")
    private Boolean serviceInformationSaveOnCian = false;
    @Column(name = "service_information_save_on_avito")
    private Boolean serviceInformationSaveOnAvito = false;
    @Column(name = "service_information_save_on_domclick")
    private Boolean serviceInformationSaveOnDomclick = false;
    @Column(name = "service_information_save_on_yandex")
    private Boolean serviceInformationSaveOnYandex = false;
}