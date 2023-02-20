package com.argroupcrm.crm.dto.cian;

import com.argroupcrm.crm.model.json.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.argroupcrm.crm.model.cian.BuildingCianEntity} entity
 */
@Data
@Builder
@AllArgsConstructor
public class BuildingCianEntityDto implements Serializable {
    private final Long id;
    private final String mainPropertyType;
    private final String mainDescription;
    private final String mainGuestCount;
    private final String mainAddress;
    private final String mainCoordinatesLat;
    private final String mainCoordinatesLng;
    private final String mainCadastralNumber;
    private final List<List<PhoneJson>> mainPhonesSchema;
    private final String mainHighwayDistance;
    private final String mainHigwayId;
    private final List<List<HighwayJson>> mainHighwaySchema;
    private final List<List<UndegroundJson>> mainUndegroundsSchema;
    private final String mainBookingStatus;
    private final String mainSubagentEmail;
    private final String mainSubagentPhone;
    private final String mainSubagentFirstName;
    private final String mainSubagentLastName;
    private final String mainSubagentAvatar;
    private final String mainLayoutphotoUrl;
    private final Boolean mainLayoutphotoIsDefault;
    private final String mainLayoutphotoPhotoType;
    private final List<List<PhotosJson>> mainPhotoSchema;
    private final List<List<VideoJson>> mainVideoSchema;
    private final String mainPremiumTitle;
    private final Boolean mainIsRentByParts;
    private final String mainRentByPartsDesc;
    private final Boolean mainPublishTermsIgnore;
    private final List<List<PublisherTermsSchemaServicesJson>> mainJsonPublisherTermsSchemaServices;
    private final List<List<PublisherTermsSchemaExcludedServicesJson>> mainJsonPublisherTermsSchemaExcludedServices;
    private final String mainExtraDataHomeOwnerName;
    private final String mainExtraDataHomeOwnerPhone;
    private final String mainExtraDataExacAddres;
    private final String mainAuctionBet;
    private final String categoryBuilding;
    private final String conditionType;
    private final String layout;
    private final Boolean hasFurniture;
    private final String inputType;
    private final String availableFrom;
    private final String taxNumber;
    private final Boolean isInHiddenBase;
    private final String title;
    private final String buildingName;
    private final String buildingBuildYear;
    private final String buildingMaterialType;
    private final String buildingFloorsCount;
    private final String buildingTotalArea;
    private final String buildingHeatingType;
    private final String buildingCellingHeight;
    private final String buildingParkingType;
    private final String buildingParkingPlacesCount;
    private final String buildingParkingPriceMonthly;
    private final Boolean buildingParkingIsFree;
    private final String buildingType;
    private final String buildingHouseLineType;
    private final String buildingClassType;
    private final String buildingDeveloper;
    private final String buildingManagementCompany;
    private final String buildingVentilationType;
    private final String buildingConditioningType;
    private final String buildingExtinguishingType;
    private final List<List<ExtinguishingSystemTypeJson>> buildingExtinguishingSystemTypesSchema;
    private final List<List<LiftTypeJson>> buildingLiftTypesSchema;
    private final List<List<String>> buildingInfrustructure;
    private final String buildingAccessType;
    private final String buildingStatusType;
    private final String landArea;
    private final String landAreaUnitType;
    private final String landAreaType;
    private final List<List<AreaPartsRentByPartsJson>> areaPartsRentByPartsSchema;
    private final List<List<MultiListingSlotsJson>> multiListingSlotsSchema;
    private final String bargainTermsPrice;
    private final String bargainTermsPriceType;
    private final String bargainTermsCurrency;
    private final String bargainTermsPaymentPeriod;
    private final String bargainTermsVatType;
    private final String bargainTermsLeaseType;
    private final List<List<IncludedOptionsEnumJson>> bargainTermsIncludeOptionsEnum;
    private final String bargainTermsLeaseTermType;
    private final String bargainTermsLeaseMinLeaseTerm;
    private final String bargainTermsPrepayMonths;
    private final Boolean bargainTermsHasGracePeriod;
    private final String bargainTermsDeposit;
    private final String bargainTermsClientFee;
    private final String bargainTermsSecurityDeposit;
    private final String bargainTermsAgentFee;
    private final String bargainTermsAgentBonusValue;
    private final String bargainTermsAgentBonusPaymentType;
    private final String bargainTermsAgentBonusCurrency;
    private final Boolean serviceInformationSaveOnCian;
    private final Boolean serviceInformationSaveOnAvito;
    private final Boolean serviceInformationSaveOnDomclick;
    private final Boolean serviceInformationSaveOnYandex;
}