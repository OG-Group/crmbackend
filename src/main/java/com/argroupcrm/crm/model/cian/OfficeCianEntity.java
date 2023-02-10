package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "office_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeCianEntity extends AbstractEntity {
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
    @Column(name = "tataol_area")
    private Double tataolArea;
    @Column(name = "min_area")
    private Double minArea;
    @Column(name = "floor_num")
    private Integer floorNum;
    @Column(name = "condition_type")
    private String conditionType;
    @Column(name = "is_occuped")
    private Boolean isOccuped;
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
    @Column(name = "isln_hidden_base")
    private Boolean islnHiddenBase;
    @Column(name = "buisness_shopping_center_id")
    private Integer buisnessShoppingCenterId;

}