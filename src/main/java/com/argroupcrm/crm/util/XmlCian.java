package com.argroupcrm.crm.util;

import com.argroupcrm.crm.generic.crud.controller.AbstractException;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.model.json.*;
import lombok.Data;
import org.apache.commons.lang3.Range;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author ogbozoyan
 * @date 26.02.2023
 */
@Data
@Component
public class XmlCian {
    private SimpleDateFormat dateFormat;
    private Date date;
    private TransformerFactory transformerFactory;
    private Transformer transformer;

    public XmlCian() throws TransformerConfigurationException {
        //решить проблему с индентом, добавляет лишние пробелы при каждом добавлении
        this.dateFormat = new SimpleDateFormat("_dd_MM_yyyy");
        this.date = new Date();
        this.transformerFactory = TransformerFactory.newInstance();
        this.transformer = transformerFactory.newTransformer();
        this.transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        this.transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no"); // убирает хедер
//        this.transformer.setOutputProperty(OutputKeys.INDENT, "no"); //форматирует в читаемый вид
    }

    public void CianRentBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        File cianFeed = new File("cianFeed" + dateFormat.format(date) + ".xml");

        if (cianFeed.exists()) {
            Document doc = docBuilder.parse(cianFeed);
            Add2CianRentBuildingXML(cianFeed, doc, entity, countAvailablePremium);
            return;
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("feed");
        doc.appendChild(rootElement);
        //feed version
        Element feedVersion = doc.createElement("feed_version");
        feedVersion.appendChild(doc.createTextNode("2"));
        rootElement.appendChild(feedVersion);
        Element object = doc.createElement("object");
        rootElement.appendChild(object);

        if (entity.getCategoryBuilding() == null || entity.getCategoryBuilding().isEmpty()) {
            throw new AbstractException("Building category can't be null");
        }
        Element category = doc.createElement("Category");
        category.appendChild(doc.createTextNode(entity.getCategoryBuilding()));
        object.appendChild(category);

        Element auction = doc.createElement("Auction");
        Element bet = doc.createElement("Bet");
        bet.appendChild(doc.createTextNode(entity.getMainAuctionBet()));

        auction.appendChild(bet);
        object.appendChild(auction);

        Element externalId = doc.createElement("ExternalId");
        externalId.appendChild(doc.createTextNode(String.valueOf(entity.getId())));
        object.appendChild(externalId);

        Element description = doc.createElement("Description");
        description.appendChild(doc.createTextNode(entity.getMainDescription()));
        object.appendChild(description);

        Element address = doc.createElement("Address");
        address.appendChild(doc.createTextNode(entity.getMainAddress()));
        object.appendChild(address);

        Element coordinates = doc.createElement("Coordinates");
        Element lat = doc.createElement("Lat");
        Element lng = doc.createElement("Lng");
        lat.appendChild(doc.createTextNode(entity.getMainCoordinatesLat()));
        lng.appendChild(doc.createTextNode(entity.getMainCoordinatesLng()));
        coordinates.appendChild(lat);
        coordinates.appendChild(lng);
        object.appendChild(coordinates);

        Element cadastralNumber = doc.createElement("CadastralNumber");
        cadastralNumber.appendChild(doc.createTextNode(entity.getMainCadastralNumber()));
        object.appendChild(cadastralNumber);

        Element phones = doc.createElement("Phones");
        if (!entity.getMainPhonesSchema().isEmpty()) {
            for (PhoneJson phone : entity.getMainPhonesSchema()) {
                Element phoneSchema = doc.createElement("PhoneSchema");
                Element countryCode = doc.createElement("CountryCode");
                Element number = doc.createElement("Number");
                countryCode.appendChild(doc.createTextNode(phone.getCountryCode()));
                number.appendChild(doc.createTextNode(phone.getCountryCode()));
                phoneSchema.appendChild(countryCode);
                phoneSchema.appendChild(number);
                phones.appendChild(phoneSchema);
            }
        }
        object.appendChild(phones);

        Element highway = doc.createElement("Highway");
        Element id = doc.createElement("Id");
        Element distance = doc.createElement("Distance");
        id.appendChild(doc.createTextNode(entity.getMainHigwayId()));
        distance.appendChild(doc.createTextNode(entity.getMainHighwayDistance()));
        highway.appendChild(id);
        highway.appendChild(distance);
        object.appendChild(highway);

        Element higways = doc.createElement("Highways");
        if (!entity.getMainHighwaySchema().isEmpty()) {
            for (HighwayJson highways : entity.getMainHighwaySchema()) {
                Element highwayInfoSchema = doc.createElement("HighwayInfoSchema");
                Element idHighway = doc.createElement("Id");
                Element distanceHigway = doc.createElement("Distance");
                idHighway.appendChild(doc.createTextNode(highways.getId()));
                distanceHigway.appendChild(doc.createTextNode(highways.getDistance()));
                highwayInfoSchema.appendChild(idHighway);
                highwayInfoSchema.appendChild(distanceHigway);
                higways.appendChild(highwayInfoSchema);
            }
        }
        object.appendChild(higways);

        Element undegrounds = doc.createElement("Undergrounds");
        if (!entity.getMainUndegroundsSchema().isEmpty()) {
            for (UndegroundJson undeground : entity.getMainUndegroundsSchema()) {
                Element undergroundInfoSchema = doc.createElement("UndergroundInfoSchema");
                Element idUndeground = doc.createElement("Id");
                Element timeUndeground = doc.createElement("Time");
                Element transportType = doc.createElement("TransportType");
                idUndeground.appendChild(doc.createTextNode(undeground.getId()));
                timeUndeground.appendChild(doc.createTextNode(undeground.getTime()));
                transportType.appendChild(doc.createTextNode(undeground.getTransportType()));
                undergroundInfoSchema.appendChild(idUndeground);
                undergroundInfoSchema.appendChild(timeUndeground);
                undergroundInfoSchema.appendChild(transportType);
                undegrounds.appendChild(undergroundInfoSchema);
            }
        }
        object.appendChild(undegrounds);

        Element booking = doc.createElement("Booking");
        Element status = doc.createElement("Status");
        status.appendChild(doc.createTextNode(entity.getMainBookingStatus()));
        booking.appendChild(status);
        object.appendChild(booking);

        Element coonditionType = doc.createElement("ConditionType");
        coonditionType.appendChild(doc.createTextNode(entity.getConditionType()));
        object.appendChild(coonditionType);

        Element subAgent = doc.createElement("SubAgent");
        Element sEmail = doc.createElement("Email");
        Element sPhone = doc.createElement("Phone");
        Element fName = doc.createElement("FirstName");
        Element lName = doc.createElement("LastName");
        Element sAvatar = doc.createElement("AvatarUrl");
        sEmail.appendChild(doc.createTextNode(entity.getMainSubagentEmail()));
        sPhone.appendChild(doc.createTextNode(entity.getMainSubagentPhone()));
        fName.appendChild(doc.createTextNode(entity.getMainSubagentFirstName()));
        lName.appendChild(doc.createTextNode(entity.getMainSubagentLastName()));
        sAvatar.appendChild(doc.createTextNode(entity.getMainSubagentAvatar()));
        subAgent.appendChild(sEmail);
        subAgent.appendChild(sPhone);
        subAgent.appendChild(fName);
        subAgent.appendChild(lName);
        subAgent.appendChild(sAvatar);
        object.appendChild(subAgent);

        Element layout = doc.createElement("Layout");
        layout.appendChild(doc.createTextNode(entity.getLayout()));
        object.appendChild(layout);

        Element lPhoto = doc.createElement("LayoutPhoto");
        Element lPhotoUrl = doc.createElement("FullUrl");
        Element lIsDefault = doc.createElement("IsDefault");
        lPhotoUrl.appendChild(doc.createTextNode(entity.getMainLayoutphotoUrl()));
        lIsDefault.appendChild(doc.createTextNode(String.valueOf(entity.getMainLayoutphotoIsDefault())));
        lPhoto.appendChild(lPhotoUrl);
        lPhoto.appendChild(lIsDefault);
        object.appendChild(lPhoto);

        Element photos = doc.createElement("Photos");
        if (!entity.getMainPhotoSchema().isEmpty()) {
            for (PhotosJson photo : entity.getMainPhotoSchema()) {
                Element photoSchema = doc.createElement("PhotoSchema");
                Element fullUrl = doc.createElement("FullUrl");
                Element isDefault = doc.createElement("IsDefault");
                fullUrl.appendChild(doc.createTextNode(photo.getFullUrl()));
                isDefault.appendChild(doc.createTextNode(String.valueOf(photo.getIsDefault())));
                photoSchema.appendChild(fullUrl);
                photoSchema.appendChild(isDefault);
                photos.appendChild(photoSchema);
            }
        }
        object.appendChild(photos);

        Element hasFurniture = doc.createElement("HasFurniture");
        hasFurniture.appendChild(doc.createTextNode(String.valueOf(entity.getHasFurniture())));
        object.appendChild(hasFurniture);

        Element inputType = doc.createElement("InputType");
        inputType.appendChild(doc.createTextNode(entity.getInputType()));
        object.appendChild(inputType);

        Element availableFrom = doc.createElement("AvailableFrom");
        availableFrom.appendChild(doc.createTextNode(entity.getAvailableFrom()));
        object.appendChild(availableFrom);

        Element taxNumber = doc.createElement("TaxNumber");
        taxNumber.appendChild(doc.createTextNode(entity.getTaxNumber()));
        object.appendChild(taxNumber);

        Element isInHiddenBase = doc.createElement("IsInHiddenBase");
        isInHiddenBase.appendChild(doc.createTextNode(String.valueOf(entity.getIsInHiddenBase())));
        object.appendChild(isInHiddenBase);

        Element videos = doc.createElement("Videos");
        if (!entity.getMainVideoSchema().isEmpty()) {
            for (VideoJson video : entity.getMainVideoSchema()) {
                Element videoSchema = doc.createElement("VideoSchema");
                Element videoUrl = doc.createElement("Url");
                videoUrl.appendChild(doc.createTextNode(video.getUrl()));
                videoSchema.appendChild(videoUrl);
                videos.appendChild(videoSchema);
            }
        }
        object.appendChild(videos);

        //if premium can upload with custom title
        if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
            if ((entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("premium") || entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("top3")) && (countAvailablePremium > 0)) {
                Element title = doc.createElement("Title");
                title.appendChild(doc.createTextNode(entity.getTitle()));
                object.appendChild(title);
            }
        }

        Element building = doc.createElement("Building");
        Element nameb = doc.createElement("Name");
        nameb.appendChild(doc.createTextNode(entity.getBuildingName()));
        building.appendChild(nameb);

        if (entity.getBuildingFloorsCount() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building floors count can't be null");
        }
        Element floorsCount = doc.createElement("FloorsCount");
        floorsCount.appendChild(doc.createTextNode(entity.getBuildingFloorsCount()));
        building.appendChild(floorsCount);
        if (entity.getBuildingTotalArea() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building totalArea count can't be null");
        }
        Element totalArea = doc.createElement("TotalArea");
        totalArea.appendChild(doc.createTextNode(entity.getBuildingTotalArea()));
        building.appendChild(totalArea);

        Element heatingType = doc.createElement("HeatingType");
        heatingType.appendChild(doc.createTextNode(entity.getBuildingHeatingType()));
        building.appendChild(heatingType);

        Element ceilingHeight = doc.createElement("CeilingHeight");
        ceilingHeight.appendChild(doc.createTextNode(entity.getBuildingCellingHeight()));
        building.appendChild(ceilingHeight);

        Element parking = doc.createElement("Parking");
        Element typeP = doc.createElement("Type");
        typeP.appendChild(doc.createTextNode(entity.getBuildingParkingType()));
        Element placesCount = doc.createElement("PlacesCount");
        placesCount.appendChild(doc.createTextNode(entity.getBuildingParkingPlacesCount()));
        Element priceMounthly = doc.createElement("PriceMonthly");
        priceMounthly.appendChild(doc.createTextNode(entity.getBuildingParkingPriceMonthly()));
        Element pIsFree = doc.createElement("IsFree");
        pIsFree.appendChild(doc.createTextNode(String.valueOf(entity.getBuildingParkingIsFree())));
        parking.appendChild(typeP);
        parking.appendChild(placesCount);
        parking.appendChild(priceMounthly);
        parking.appendChild(pIsFree);
        building.appendChild(parking);

        Element buildingType = doc.createElement("Type");
        buildingType.appendChild(doc.createTextNode(entity.getBuildingType()));
        building.appendChild(buildingType);

        Element houseLine = doc.createElement("HouseLineType");
        houseLine.appendChild(doc.createTextNode(entity.getBuildingHouseLineType()));
        building.appendChild(houseLine);

        Element classType = doc.createElement("ClassType");
        classType.appendChild(doc.createTextNode(entity.getBuildingClassType()));
        building.appendChild(classType);

        Element developer = doc.createElement("Developer");
        developer.appendChild(doc.createTextNode(entity.getBuildingDeveloper()));
        building.appendChild(developer);

        Element managementCompany = doc.createElement("ManagementCompany");
        managementCompany.appendChild(doc.createTextNode(entity.getBuildingManagementCompany()));
        building.appendChild(managementCompany);

        Element ventilationType = doc.createElement("VentilationType");
        ventilationType.appendChild(doc.createTextNode(entity.getBuildingVentilationType()));
        building.appendChild(ventilationType);

        Element conditioningType = doc.createElement("ConditioningType");
        conditioningType.appendChild(doc.createTextNode(entity.getBuildingConditioningType()));
        building.appendChild(conditioningType);

        Element extinguishingSystemType = doc.createElement("ExtinguishingSystemType");
        extinguishingSystemType.appendChild(doc.createTextNode(entity.getBuildingExtinguishingType()));
        building.appendChild(extinguishingSystemType);

        Element extinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypes");
        if (!entity.getBuildingExtinguishingSystemTypesSchema().isEmpty()) {
            for (ExtinguishingSystemTypeJson ext : entity.getBuildingExtinguishingSystemTypesSchema()) {
                Element eExtinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypeEnum");
                eExtinguishingSystemTypes.appendChild(doc.createTextNode(ext.getExtinguishingSystemTypeEnum()));
                extinguishingSystemTypes.appendChild(eExtinguishingSystemTypes);
            }
        }
        building.appendChild(extinguishingSystemTypes);

        Element liftTypes = doc.createElement("LiftTypes");
        if (!entity.getBuildingLiftTypesSchema().isEmpty()) {
            for (LiftTypeJson lift : entity.getBuildingLiftTypesSchema()) {
                Element liftTypeSchema = doc.createElement("LiftTypeSchema");
                Element type = doc.createElement("Type");
                Element additionalType = doc.createElement("AdditionalType");
                Element count = doc.createElement("Count");
                type.appendChild(doc.createTextNode(lift.getType()));
                additionalType.appendChild(doc.createTextNode(lift.getAdditionalType()));
                count.appendChild(doc.createTextNode(lift.getCount()));
                liftTypeSchema.appendChild(type);
                liftTypeSchema.appendChild(additionalType);
                liftTypeSchema.appendChild(count);
                liftTypes.appendChild(liftTypeSchema);
            }
        }
        building.appendChild(liftTypes);

        Element statusType = doc.createElement("StatusType");
        statusType.appendChild(doc.createTextNode(entity.getBuildingStatusType()));
        building.appendChild(statusType);

        object.appendChild(building);

        Element land = doc.createElement("Land");
        Element landArea = doc.createElement("Area");
        landArea.appendChild(doc.createTextNode(entity.getLandArea()));
        land.appendChild(landArea);
        Element landAreaUnit = doc.createElement("AreaUnitType");
        landAreaUnit.appendChild(doc.createTextNode(entity.getLandAreaUnitType()));
        land.appendChild(landAreaUnit);
        Element landType = doc.createElement("Type");
        landType.appendChild(doc.createTextNode(entity.getLandAreaType()));
        land.appendChild(landType);

        object.appendChild(land);

        Element rentByPartsDescription = doc.createElement("RentByPartsDescription");
        rentByPartsDescription.appendChild(doc.createTextNode(entity.getMainRentByPartsDesc()));
        object.appendChild(rentByPartsDescription);

        Element areaParts = doc.createElement("AreaParts");
        if (!entity.getAreaPartsRentByPartsSchema().isEmpty()) {
            for (AreaPartsRentByPartsJson parts : entity.getAreaPartsRentByPartsSchema()) {
                Element rentByPartsSchema = doc.createElement("RentByPartsSchema");
                Element area = doc.createElement("Area");
                area.appendChild(doc.createTextNode(parts.getArea()));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(parts.getPrice()));
                rentByPartsSchema.appendChild(area);
                rentByPartsSchema.appendChild(price);
                areaParts.appendChild(rentByPartsSchema);
            }
        }
        object.appendChild(areaParts);
        Range<Integer> range = Range.between(2, 30);
        if (!entity.getMultiListingSlotsSchema().isEmpty() && range.contains(entity.getMultiListingSlotsSchema().size())) {
            Element multiListingSlots = doc.createElement("MultiListingSlots");
            for (MultiListingSlotsJson multi : entity.getMultiListingSlotsSchema()) {
                if (multi.getArea() == null || multi.getArea().isEmpty()) {
                    throw new RuntimeException("MultiListing Area can't be null");
                }
                if (multi.getPrice() == null || multi.getPrice().isEmpty()) {
                    throw new RuntimeException("MultiListing Price can't be null");
                }
                if (multi.getFloorFrom() == null || multi.getFloorFrom().isEmpty()) {
                    throw new RuntimeException("MultiListing FloorFrom can't be null");
                }
                if (multi.getPriceType() == null || multi.getPriceType().isEmpty()) {
                    throw new RuntimeException("MultiListing PriceType can't be null");
                }
                if (multi.getPaymentPeriod() == null || multi.getPaymentPeriod().isEmpty()) {
                    throw new RuntimeException("MultiListing PaymentPeriod can't be null");
                }
                Element commercialMultiListingSlotSchema = doc.createElement("CommercialMultiListingSlotSchema");
                Element areaCom = doc.createElement("Area");
                Element priceCom = doc.createElement("Price");
                Element floorFromCom = doc.createElement("FloorFrom");
                Element floorToCom = doc.createElement("FloorTo");
                areaCom.appendChild(doc.createTextNode(multi.getArea()));
                priceCom.appendChild(doc.createTextNode(multi.getPrice()));
                floorFromCom.appendChild(doc.createTextNode(multi.getFloorFrom()));
                floorToCom.appendChild(doc.createTextNode(multi.getFloorTo()));
                commercialMultiListingSlotSchema.appendChild(areaCom);
                commercialMultiListingSlotSchema.appendChild(priceCom);
                commercialMultiListingSlotSchema.appendChild(floorFromCom);
                commercialMultiListingSlotSchema.appendChild(floorToCom);
                Element priceTypeCom = doc.createElement("PriceType");
                Element paymentPeriodCom = doc.createElement("PaymentPeriod");
                priceTypeCom.appendChild(doc.createTextNode(multi.getPriceType()));
                paymentPeriodCom.appendChild(doc.createTextNode(multi.getPaymentPeriod()));
                commercialMultiListingSlotSchema.appendChild(priceTypeCom);
                commercialMultiListingSlotSchema.appendChild(paymentPeriodCom);
                Element photosCom = doc.createElement("Photos");
                if (!multi.getPhotosUrl().isEmpty()) {
                    for (String photoCom : multi.getPhotosUrl()) {
                        Element commercialMultiListingSlotPhotoSchema = doc.createElement("CommercialMultiListingSlotPhotoSchema");
                        Element urlPhotoCom = doc.createElement("Url");
                        urlPhotoCom.appendChild(doc.createTextNode(photoCom));
                        commercialMultiListingSlotPhotoSchema.appendChild(urlPhotoCom);
                        photosCom.appendChild(commercialMultiListingSlotPhotoSchema);
                    }
                }
                commercialMultiListingSlotSchema.appendChild(photosCom);
                multiListingSlots.appendChild(commercialMultiListingSlotSchema);
            }
            object.appendChild(multiListingSlots);
        }
        if (!entity.getMainPublishTermsIgnore()) {
            Element publisherTerms = doc.createElement("PublishTerms");
            Element terms = doc.createElement("Terms");
            Element publisherTermsSchema = doc.createElement("PublishTermSchema");
            Element services = doc.createElement("Services");
            Element excludedServices = doc.createElement("ExcludedServices");
            if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
                for (PublisherTermsSchemaServicesJson serv : entity.getMainJsonPublisherTermsSchemaServices()) {
                    Element servicesEnum = doc.createElement("ServicesEnum");
                    servicesEnum.appendChild(doc.createTextNode(serv.getServicesEnum()));
                    services.appendChild(servicesEnum);
                }
                publisherTermsSchema.appendChild(services);
            }
            if (!entity.getMainJsonPublisherTermsSchemaExcludedServices().isEmpty()) {
                for (PublisherTermsSchemaExcludedServicesJson excluded : entity.getMainJsonPublisherTermsSchemaExcludedServices()) {
                    Element excludedServicesEnum = doc.createElement("ExcludedServicesEnum");
                    excludedServicesEnum.appendChild(doc.createTextNode(excluded.getExcludedServicesEnum()));
                    excludedServices.appendChild(excludedServicesEnum);
                }
                publisherTermsSchema.appendChild(excludedServices);
            }
            terms.appendChild(publisherTermsSchema);
            publisherTerms.appendChild(terms);
            object.appendChild(publisherTerms);
        }
        Element extraData = doc.createElement("ExtraData");
        Element exHomeOwnerName = doc.createElement("HomeOwnerName");
        Element exHomeOwnerPhone = doc.createElement("HomeOwnerPhone");
        Element exExactAddress = doc.createElement("ExactAddress");
        exHomeOwnerName.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerName()));
        exHomeOwnerPhone.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerPhone()));
        exExactAddress.appendChild(doc.createTextNode(entity.getMainExtraDataExacAddres()));
        extraData.appendChild(exHomeOwnerName);
        extraData.appendChild(exHomeOwnerPhone);
        extraData.appendChild(exExactAddress);

        object.appendChild(extraData);

        Element bargainTerms = doc.createElement("BargainTerms");
        if (entity.getBargainTermsPrice() == null || entity.getBargainTermsPrice().isEmpty()) {
            throw new RuntimeException("BargainTerms Price can't be null");
        }
        Element btPrice = doc.createElement("Price");
        btPrice.appendChild(doc.createTextNode(entity.getBargainTermsPrice()));
        Element btPriceType = doc.createElement("PriceType");
        btPriceType.appendChild(doc.createTextNode(entity.getBargainTermsPriceType()));
        Element btCurrency = doc.createElement("Currency");
        btCurrency.appendChild(doc.createTextNode(entity.getBargainTermsCurrency()));
        Element btPaymentPeriod = doc.createElement("PaymentPeriod");
        btPaymentPeriod.appendChild(doc.createTextNode(entity.getBargainTermsPaymentPeriod()));
        if (entity.getBargainTermsVatType() == null || entity.getBargainTermsVatType().isEmpty()) {
            throw new RuntimeException("BargainTerms VatType can't be null");
        }
        Element btVatType = doc.createElement("VatType");
        btVatType.appendChild(doc.createTextNode(entity.getBargainTermsVatType()));
        Element btLeaseType = doc.createElement("LeaseType");
        btLeaseType.appendChild(doc.createTextNode(entity.getBargainTermsLeaseType()));
        bargainTerms.appendChild(btPrice);
        bargainTerms.appendChild(btPriceType);
        bargainTerms.appendChild(btCurrency);
        bargainTerms.appendChild(btPaymentPeriod);
        bargainTerms.appendChild(btVatType);
        bargainTerms.appendChild(btLeaseType);
        Element includedOptions = doc.createElement("IncludedOptions");
        if (!entity.getBargainTermsIncludeOptionsEnum().isEmpty()) {
            for (IncludedOptionsEnumJson option : entity.getBargainTermsIncludeOptionsEnum()) {
                Element includedOptionsEnum = doc.createElement("IncludedOptionsEnum");
                includedOptionsEnum.appendChild(doc.createTextNode(option.getIncludedOptionsEnum()));
                includedOptions.appendChild(includedOptionsEnum);
            }
        }
        bargainTerms.appendChild(includedOptions);

        Element leaseTermType = doc.createElement("LeaseTermType");
        leaseTermType.appendChild(doc.createTextNode(entity.getBargainTermsLeaseTermType()));
        Element minLeaseTerm = doc.createElement("MinLeaseTerm");
        minLeaseTerm.appendChild(doc.createTextNode(entity.getBargainTermsLeaseMinLeaseTerm()));
        Element btPrepayMonths = doc.createElement("PrepayMonths");
        btPrepayMonths.appendChild(doc.createTextNode(entity.getBargainTermsPrepayMonths()));
        Element hasGrace = doc.createElement("HasGracePeriod");
        hasGrace.appendChild(doc.createTextNode(String.valueOf(entity.getBargainTermsHasGracePeriod())));
        Element btDeposit = doc.createElement("Deposit");
        btDeposit.appendChild(doc.createTextNode(entity.getBargainTermsDeposit()));
        Element btClientFee = doc.createElement("ClientFee");
        btClientFee.appendChild(doc.createTextNode(entity.getBargainTermsClientFee()));
        Element btSecurityDeposit = doc.createElement("SecurityDeposit");
        btSecurityDeposit.appendChild(doc.createTextNode(entity.getBargainTermsSecurityDeposit()));
        Element agentFee = doc.createElement("AgentFee");
        agentFee.appendChild(doc.createTextNode(entity.getBargainTermsAgentFee()));
        bargainTerms.appendChild(leaseTermType);
        bargainTerms.appendChild(minLeaseTerm);
        bargainTerms.appendChild(btPrepayMonths);
        bargainTerms.appendChild(hasGrace);
        bargainTerms.appendChild(btDeposit);
        bargainTerms.appendChild(btClientFee);
        bargainTerms.appendChild(btSecurityDeposit);
        bargainTerms.appendChild(agentFee);

        Element agentBonus = doc.createElement("AgentBonus");
        Element abValue = doc.createElement("Value");
        abValue.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusValue()));
        Element abPaymentType = doc.createElement("PaymentType");
        abPaymentType.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusPaymentType()));
        Element abCurrency = doc.createElement("Currency");
        abCurrency.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusCurrency()));
        agentBonus.appendChild(abValue);
        agentBonus.appendChild(abPaymentType);
        agentBonus.appendChild(abCurrency);
        bargainTerms.appendChild(agentBonus);

        object.appendChild(bargainTerms);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(cianFeed);

        transformer.transform(source, result);

    }

    private void Add2CianRentBuildingXML(File cianFeed, Document doc, BuildingCianEntity entity, Integer countAvailablePremium) throws TransformerException {

        // root elements
        Element rootElement = doc.getDocumentElement();
        Element object = doc.createElement("object");

        if (entity.getCategoryBuilding() == null || entity.getCategoryBuilding().isEmpty()) {
            throw new AbstractException("Building category can't be null");
        }
        Element category = doc.createElement("Category");
        category.appendChild(doc.createTextNode(entity.getCategoryBuilding()));
        object.appendChild(category);

        Element auction = doc.createElement("Auction");
        Element bet = doc.createElement("Bet");
        bet.appendChild(doc.createTextNode(entity.getMainAuctionBet()));
        auction.appendChild(bet);
        object.appendChild(auction);

        Element externalId = doc.createElement("ExternalId");
        externalId.appendChild(doc.createTextNode(String.valueOf(entity.getId())));
        object.appendChild(externalId);

        Element description = doc.createElement("Description");
        description.appendChild(doc.createTextNode(entity.getMainDescription()));
        object.appendChild(description);

        Element address = doc.createElement("Address");
        address.appendChild(doc.createTextNode(entity.getMainAddress()));
        object.appendChild(address);

        Element coordinates = doc.createElement("Coordinates");
        Element lat = doc.createElement("Lat");
        Element lng = doc.createElement("Lng");
        lat.appendChild(doc.createTextNode(entity.getMainCoordinatesLat()));
        lng.appendChild(doc.createTextNode(entity.getMainCoordinatesLng()));
        coordinates.appendChild(lat);
        coordinates.appendChild(lng);
        object.appendChild(coordinates);

        Element cadastralNumber = doc.createElement("CadastralNumber");
        cadastralNumber.appendChild(doc.createTextNode(entity.getMainCadastralNumber()));
        object.appendChild(cadastralNumber);

        Element phones = doc.createElement("Phones");
        if (!entity.getMainPhonesSchema().isEmpty()) {
            for (PhoneJson phone : entity.getMainPhonesSchema()) {
                Element phoneSchema = doc.createElement("PhoneSchema");
                Element countryCode = doc.createElement("CountryCode");
                Element number = doc.createElement("Number");
                countryCode.appendChild(doc.createTextNode(phone.getCountryCode()));
                number.appendChild(doc.createTextNode(phone.getCountryCode()));
                phoneSchema.appendChild(countryCode);
                phoneSchema.appendChild(number);
                phones.appendChild(phoneSchema);
            }
        }
        object.appendChild(phones);

        Element highway = doc.createElement("Highway");
        Element id = doc.createElement("Id");
        Element distance = doc.createElement("Distance");
        id.appendChild(doc.createTextNode(entity.getMainHigwayId()));
        distance.appendChild(doc.createTextNode(entity.getMainHighwayDistance()));
        highway.appendChild(id);
        highway.appendChild(distance);
        object.appendChild(highway);

        Element higways = doc.createElement("Highways");
        if (!entity.getMainHighwaySchema().isEmpty()) {
            for (HighwayJson highways : entity.getMainHighwaySchema()) {
                Element highwayInfoSchema = doc.createElement("HighwayInfoSchema");
                Element idHighway = doc.createElement("Id");
                Element distanceHigway = doc.createElement("Distance");
                idHighway.appendChild(doc.createTextNode(highways.getId()));
                distanceHigway.appendChild(doc.createTextNode(highways.getDistance()));
                highwayInfoSchema.appendChild(idHighway);
                highwayInfoSchema.appendChild(distanceHigway);
                higways.appendChild(highwayInfoSchema);
            }
        }
        object.appendChild(higways);

        Element undegrounds = doc.createElement("Undergrounds");
        if (!entity.getMainUndegroundsSchema().isEmpty()) {
            for (UndegroundJson undeground : entity.getMainUndegroundsSchema()) {
                Element undergroundInfoSchema = doc.createElement("UndergroundInfoSchema");
                Element idUndeground = doc.createElement("Id");
                Element timeUndeground = doc.createElement("Time");
                Element transportType = doc.createElement("TransportType");
                idUndeground.appendChild(doc.createTextNode(undeground.getId()));
                timeUndeground.appendChild(doc.createTextNode(undeground.getTime()));
                transportType.appendChild(doc.createTextNode(undeground.getTransportType()));
                undergroundInfoSchema.appendChild(idUndeground);
                undergroundInfoSchema.appendChild(timeUndeground);
                undergroundInfoSchema.appendChild(transportType);
                undegrounds.appendChild(undergroundInfoSchema);
            }
        }
        object.appendChild(undegrounds);

        Element booking = doc.createElement("Booking");
        Element status = doc.createElement("Status");
        status.appendChild(doc.createTextNode(entity.getMainBookingStatus()));
        booking.appendChild(status);
        object.appendChild(booking);

        Element coonditionType = doc.createElement("ConditionType");
        coonditionType.appendChild(doc.createTextNode(entity.getConditionType()));
        object.appendChild(coonditionType);

        Element subAgent = doc.createElement("SubAgent");
        Element sEmail = doc.createElement("Email");
        Element sPhone = doc.createElement("Phone");
        Element fName = doc.createElement("FirstName");
        Element lName = doc.createElement("LastName");
        Element sAvatar = doc.createElement("AvatarUrl");
        sEmail.appendChild(doc.createTextNode(entity.getMainSubagentEmail()));
        sPhone.appendChild(doc.createTextNode(entity.getMainSubagentPhone()));
        fName.appendChild(doc.createTextNode(entity.getMainSubagentFirstName()));
        lName.appendChild(doc.createTextNode(entity.getMainSubagentLastName()));
        sAvatar.appendChild(doc.createTextNode(entity.getMainSubagentAvatar()));
        subAgent.appendChild(sEmail);
        subAgent.appendChild(sPhone);
        subAgent.appendChild(fName);
        subAgent.appendChild(lName);
        subAgent.appendChild(sAvatar);
        object.appendChild(subAgent);

        Element layout = doc.createElement("Layout");
        layout.appendChild(doc.createTextNode(entity.getLayout()));
        object.appendChild(layout);

        Element lPhoto = doc.createElement("LayoutPhoto");
        Element lPhotoUrl = doc.createElement("FullUrl");
        Element lIsDefault = doc.createElement("IsDefault");
        lPhotoUrl.appendChild(doc.createTextNode(entity.getMainLayoutphotoUrl()));
        lIsDefault.appendChild(doc.createTextNode(String.valueOf(entity.getMainLayoutphotoIsDefault())));
        lPhoto.appendChild(lPhotoUrl);
        lPhoto.appendChild(lIsDefault);
        object.appendChild(lPhoto);

        Element photos = doc.createElement("Photos");
        if (!entity.getMainPhotoSchema().isEmpty()) {
            for (PhotosJson photo : entity.getMainPhotoSchema()) {
                Element photoSchema = doc.createElement("PhotoSchema");
                Element fullUrl = doc.createElement("FullUrl");
                Element isDefault = doc.createElement("IsDefault");
                fullUrl.appendChild(doc.createTextNode(photo.getFullUrl()));
                isDefault.appendChild(doc.createTextNode(String.valueOf(photo.getIsDefault())));
                photoSchema.appendChild(fullUrl);
                photoSchema.appendChild(isDefault);
                photos.appendChild(photoSchema);
            }
        }
        object.appendChild(photos);

        Element hasFurniture = doc.createElement("HasFurniture");
        hasFurniture.appendChild(doc.createTextNode(String.valueOf(entity.getHasFurniture())));
        object.appendChild(hasFurniture);

        Element inputType = doc.createElement("InputType");
        inputType.appendChild(doc.createTextNode(entity.getInputType()));
        object.appendChild(inputType);

        Element availableFrom = doc.createElement("AvailableFrom");
        availableFrom.appendChild(doc.createTextNode(entity.getAvailableFrom()));
        object.appendChild(availableFrom);

        Element taxNumber = doc.createElement("TaxNumber");
        taxNumber.appendChild(doc.createTextNode(entity.getTaxNumber()));
        object.appendChild(taxNumber);

        Element isInHiddenBase = doc.createElement("IsInHiddenBase");
        isInHiddenBase.appendChild(doc.createTextNode(String.valueOf(entity.getIsInHiddenBase())));
        object.appendChild(isInHiddenBase);

        Element videos = doc.createElement("Videos");
        if (!entity.getMainVideoSchema().isEmpty()) {
            for (VideoJson video : entity.getMainVideoSchema()) {
                Element videoSchema = doc.createElement("VideoSchema");
                Element videoUrl = doc.createElement("Url");
                videoUrl.appendChild(doc.createTextNode(video.getUrl()));
                videoSchema.appendChild(videoUrl);
                videos.appendChild(videoSchema);
            }
        }
        object.appendChild(videos);

        //if premium can upload with custom title
        if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
            if ((entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("premium") || entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("top3")) && (countAvailablePremium > 0)) {
                Element title = doc.createElement("Title");
                title.appendChild(doc.createTextNode(entity.getTitle()));
                object.appendChild(title);
            }
        }

        Element building = doc.createElement("Building");
        Element nameb = doc.createElement("Name");
        nameb.appendChild(doc.createTextNode(entity.getBuildingName()));
        building.appendChild(nameb);

        if (entity.getBuildingFloorsCount() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building floors count can't be null");
        }
        Element floorsCount = doc.createElement("FloorsCount");
        floorsCount.appendChild(doc.createTextNode(entity.getBuildingFloorsCount()));
        building.appendChild(floorsCount);
        if (entity.getBuildingTotalArea() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building totalArea count can't be null");
        }
        Element totalArea = doc.createElement("TotalArea");
        totalArea.appendChild(doc.createTextNode(entity.getBuildingTotalArea()));
        building.appendChild(totalArea);

        Element heatingType = doc.createElement("HeatingType");
        heatingType.appendChild(doc.createTextNode(entity.getBuildingHeatingType()));
        building.appendChild(heatingType);

        Element ceilingHeight = doc.createElement("CeilingHeight");
        ceilingHeight.appendChild(doc.createTextNode(entity.getBuildingCellingHeight()));
        building.appendChild(ceilingHeight);

        Element parking = doc.createElement("Parking");
        Element typeP = doc.createElement("Type");
        typeP.appendChild(doc.createTextNode(entity.getBuildingParkingType()));
        Element placesCount = doc.createElement("PlacesCount");
        placesCount.appendChild(doc.createTextNode(entity.getBuildingParkingPlacesCount()));
        Element priceMounthly = doc.createElement("PriceMonthly");
        priceMounthly.appendChild(doc.createTextNode(entity.getBuildingParkingPriceMonthly()));
        Element pIsFree = doc.createElement("IsFree");
        pIsFree.appendChild(doc.createTextNode(String.valueOf(entity.getBuildingParkingIsFree())));
        parking.appendChild(typeP);
        parking.appendChild(placesCount);
        parking.appendChild(priceMounthly);
        parking.appendChild(pIsFree);
        building.appendChild(parking);

        Element buildingType = doc.createElement("Type");
        buildingType.appendChild(doc.createTextNode(entity.getBuildingType()));
        building.appendChild(buildingType);

        Element houseLine = doc.createElement("HouseLineType");
        houseLine.appendChild(doc.createTextNode(entity.getBuildingHouseLineType()));
        building.appendChild(houseLine);

        Element classType = doc.createElement("ClassType");
        classType.appendChild(doc.createTextNode(entity.getBuildingClassType()));
        building.appendChild(classType);

        Element developer = doc.createElement("Developer");
        developer.appendChild(doc.createTextNode(entity.getBuildingDeveloper()));
        building.appendChild(developer);

        Element managementCompany = doc.createElement("ManagementCompany");
        managementCompany.appendChild(doc.createTextNode(entity.getBuildingManagementCompany()));
        building.appendChild(managementCompany);

        Element ventilationType = doc.createElement("VentilationType");
        ventilationType.appendChild(doc.createTextNode(entity.getBuildingVentilationType()));
        building.appendChild(ventilationType);

        Element conditioningType = doc.createElement("ConditioningType");
        conditioningType.appendChild(doc.createTextNode(entity.getBuildingConditioningType()));
        building.appendChild(conditioningType);

        Element extinguishingSystemType = doc.createElement("ExtinguishingSystemType");
        extinguishingSystemType.appendChild(doc.createTextNode(entity.getBuildingExtinguishingType()));
        building.appendChild(extinguishingSystemType);

        Element extinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypes");
        if (!entity.getBuildingExtinguishingSystemTypesSchema().isEmpty()) {
            for (ExtinguishingSystemTypeJson ext : entity.getBuildingExtinguishingSystemTypesSchema()) {
                Element eExtinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypeEnum");
                eExtinguishingSystemTypes.appendChild(doc.createTextNode(ext.getExtinguishingSystemTypeEnum()));
                extinguishingSystemTypes.appendChild(eExtinguishingSystemTypes);
            }
        }
        building.appendChild(extinguishingSystemTypes);

        Element liftTypes = doc.createElement("LiftTypes");
        if (!entity.getBuildingLiftTypesSchema().isEmpty()) {
            for (LiftTypeJson lift : entity.getBuildingLiftTypesSchema()) {
                Element liftTypeSchema = doc.createElement("LiftTypeSchema");
                Element type = doc.createElement("Type");
                Element additionalType = doc.createElement("AdditionalType");
                Element count = doc.createElement("Count");
                type.appendChild(doc.createTextNode(lift.getType()));
                additionalType.appendChild(doc.createTextNode(lift.getAdditionalType()));
                count.appendChild(doc.createTextNode(lift.getCount()));
                liftTypeSchema.appendChild(type);
                liftTypeSchema.appendChild(additionalType);
                liftTypeSchema.appendChild(count);
                liftTypes.appendChild(liftTypeSchema);
            }
        }
        building.appendChild(liftTypes);

        Element statusType = doc.createElement("StatusType");
        statusType.appendChild(doc.createTextNode(entity.getBuildingStatusType()));
        building.appendChild(statusType);

        object.appendChild(building);

        Element land = doc.createElement("Land");
        Element landArea = doc.createElement("Area");
        landArea.appendChild(doc.createTextNode(entity.getLandArea()));
        land.appendChild(landArea);
        Element landAreaUnit = doc.createElement("AreaUnitType");
        landAreaUnit.appendChild(doc.createTextNode(entity.getLandAreaUnitType()));
        land.appendChild(landAreaUnit);
        Element landType = doc.createElement("Type");
        landType.appendChild(doc.createTextNode(entity.getLandAreaType()));
        land.appendChild(landType);

        object.appendChild(land);

        Element rentByPartsDescription = doc.createElement("RentByPartsDescription");
        rentByPartsDescription.appendChild(doc.createTextNode(entity.getMainRentByPartsDesc()));
        object.appendChild(rentByPartsDescription);

        Element areaParts = doc.createElement("AreaParts");
        if (!entity.getAreaPartsRentByPartsSchema().isEmpty()) {
            for (AreaPartsRentByPartsJson parts : entity.getAreaPartsRentByPartsSchema()) {
                Element rentByPartsSchema = doc.createElement("RentByPartsSchema");
                Element area = doc.createElement("Area");
                area.appendChild(doc.createTextNode(parts.getArea()));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(parts.getPrice()));
                rentByPartsSchema.appendChild(area);
                rentByPartsSchema.appendChild(price);
                areaParts.appendChild(rentByPartsSchema);
            }
        }
        object.appendChild(areaParts);
        Range<Integer> range = Range.between(2, 30);
        if (!entity.getMultiListingSlotsSchema().isEmpty() && range.contains(entity.getMultiListingSlotsSchema().size())) {
            Element multiListingSlots = doc.createElement("MultiListingSlots");
            for (MultiListingSlotsJson multi : entity.getMultiListingSlotsSchema()) {
                if (multi.getArea() == null || multi.getArea().isEmpty()) {
                    throw new RuntimeException("MultiListing Area can't be null");
                }
                if (multi.getPrice() == null || multi.getPrice().isEmpty()) {
                    throw new RuntimeException("MultiListing Price can't be null");
                }
                if (multi.getFloorFrom() == null || multi.getFloorFrom().isEmpty()) {
                    throw new RuntimeException("MultiListing FloorFrom can't be null");
                }
                if (multi.getPriceType() == null || multi.getPriceType().isEmpty()) {
                    throw new RuntimeException("MultiListing PriceType can't be null");
                }
                if (multi.getPaymentPeriod() == null || multi.getPaymentPeriod().isEmpty()) {
                    throw new RuntimeException("MultiListing PaymentPeriod can't be null");
                }
                Element commercialMultiListingSlotSchema = doc.createElement("CommercialMultiListingSlotSchema");
                Element areaCom = doc.createElement("Area");
                Element priceCom = doc.createElement("Price");
                Element floorFromCom = doc.createElement("FloorFrom");
                Element floorToCom = doc.createElement("FloorTo");
                areaCom.appendChild(doc.createTextNode(multi.getArea()));
                priceCom.appendChild(doc.createTextNode(multi.getPrice()));
                floorFromCom.appendChild(doc.createTextNode(multi.getFloorFrom()));
                floorToCom.appendChild(doc.createTextNode(multi.getFloorTo()));
                commercialMultiListingSlotSchema.appendChild(areaCom);
                commercialMultiListingSlotSchema.appendChild(priceCom);
                commercialMultiListingSlotSchema.appendChild(floorFromCom);
                commercialMultiListingSlotSchema.appendChild(floorToCom);
                Element priceTypeCom = doc.createElement("PriceType");
                Element paymentPeriodCom = doc.createElement("PaymentPeriod");
                priceTypeCom.appendChild(doc.createTextNode(multi.getPriceType()));
                paymentPeriodCom.appendChild(doc.createTextNode(multi.getPaymentPeriod()));
                commercialMultiListingSlotSchema.appendChild(priceTypeCom);
                commercialMultiListingSlotSchema.appendChild(paymentPeriodCom);
                Element photosCom = doc.createElement("Photos");
                if (!multi.getPhotosUrl().isEmpty()) {
                    for (String photoCom : multi.getPhotosUrl()) {
                        Element commercialMultiListingSlotPhotoSchema = doc.createElement("CommercialMultiListingSlotPhotoSchema");
                        Element urlPhotoCom = doc.createElement("Url");
                        urlPhotoCom.appendChild(doc.createTextNode(photoCom));
                        commercialMultiListingSlotPhotoSchema.appendChild(urlPhotoCom);
                        photosCom.appendChild(commercialMultiListingSlotPhotoSchema);
                    }
                }
                commercialMultiListingSlotSchema.appendChild(photosCom);
                multiListingSlots.appendChild(commercialMultiListingSlotSchema);
            }
            object.appendChild(multiListingSlots);
        }
        if (!entity.getMainPublishTermsIgnore()) {
            Element publisherTerms = doc.createElement("PublishTerms");
            Element terms = doc.createElement("Terms");
            Element publisherTermsSchema = doc.createElement("PublishTermSchema");
            Element services = doc.createElement("Services");
            Element excludedServices = doc.createElement("ExcludedServices");
            if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
                for (PublisherTermsSchemaServicesJson serv : entity.getMainJsonPublisherTermsSchemaServices()) {
                    Element servicesEnum = doc.createElement("ServicesEnum");
                    servicesEnum.appendChild(doc.createTextNode(serv.getServicesEnum()));
                    services.appendChild(servicesEnum);
                }
                publisherTermsSchema.appendChild(services);
            }
            if (!entity.getMainJsonPublisherTermsSchemaExcludedServices().isEmpty()) {
                for (PublisherTermsSchemaExcludedServicesJson excluded : entity.getMainJsonPublisherTermsSchemaExcludedServices()) {
                    Element excludedServicesEnum = doc.createElement("ExcludedServicesEnum");
                    excludedServicesEnum.appendChild(doc.createTextNode(excluded.getExcludedServicesEnum()));
                    excludedServices.appendChild(excludedServicesEnum);
                }
                publisherTermsSchema.appendChild(excludedServices);
            }
            terms.appendChild(publisherTermsSchema);
            publisherTerms.appendChild(terms);
            object.appendChild(publisherTerms);
        }
        Element extraData = doc.createElement("ExtraData");
        Element exHomeOwnerName = doc.createElement("HomeOwnerName");
        Element exHomeOwnerPhone = doc.createElement("HomeOwnerPhone");
        Element exExactAddress = doc.createElement("ExactAddress");
        exHomeOwnerName.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerName()));
        exHomeOwnerPhone.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerPhone()));
        exExactAddress.appendChild(doc.createTextNode(entity.getMainExtraDataExacAddres()));
        extraData.appendChild(exHomeOwnerName);
        extraData.appendChild(exHomeOwnerPhone);
        extraData.appendChild(exExactAddress);

        object.appendChild(extraData);

        Element bargainTerms = doc.createElement("BargainTerms");
        if (entity.getBargainTermsPrice() == null || entity.getBargainTermsPrice().isEmpty()) {
            throw new RuntimeException("BargainTerms Price can't be null");
        }
        Element btPrice = doc.createElement("Price");
        btPrice.appendChild(doc.createTextNode(entity.getBargainTermsPrice()));
        Element btPriceType = doc.createElement("PriceType");
        btPriceType.appendChild(doc.createTextNode(entity.getBargainTermsPriceType()));
        Element btCurrency = doc.createElement("Currency");
        btCurrency.appendChild(doc.createTextNode(entity.getBargainTermsCurrency()));
        Element btPaymentPeriod = doc.createElement("PaymentPeriod");
        btPaymentPeriod.appendChild(doc.createTextNode(entity.getBargainTermsPaymentPeriod()));
        if (entity.getBargainTermsVatType() == null || entity.getBargainTermsVatType().isEmpty()) {
            throw new RuntimeException("BargainTerms VatType can't be null");
        }
        Element btVatType = doc.createElement("VatType");
        btVatType.appendChild(doc.createTextNode(entity.getBargainTermsVatType()));
        Element btLeaseType = doc.createElement("LeaseType");
        btLeaseType.appendChild(doc.createTextNode(entity.getBargainTermsLeaseType()));
        bargainTerms.appendChild(btPrice);
        bargainTerms.appendChild(btPriceType);
        bargainTerms.appendChild(btCurrency);
        bargainTerms.appendChild(btPaymentPeriod);
        bargainTerms.appendChild(btVatType);
        bargainTerms.appendChild(btLeaseType);
        Element includedOptions = doc.createElement("IncludedOptions");
        if (!entity.getBargainTermsIncludeOptionsEnum().isEmpty()) {
            for (IncludedOptionsEnumJson option : entity.getBargainTermsIncludeOptionsEnum()) {
                Element includedOptionsEnum = doc.createElement("IncludedOptionsEnum");
                includedOptionsEnum.appendChild(doc.createTextNode(option.getIncludedOptionsEnum()));
                includedOptions.appendChild(includedOptionsEnum);
            }
        }
        bargainTerms.appendChild(includedOptions);

        Element leaseTermType = doc.createElement("LeaseTermType");
        leaseTermType.appendChild(doc.createTextNode(entity.getBargainTermsLeaseTermType()));
        Element minLeaseTerm = doc.createElement("MinLeaseTerm");
        minLeaseTerm.appendChild(doc.createTextNode(entity.getBargainTermsLeaseMinLeaseTerm()));
        Element btPrepayMonths = doc.createElement("PrepayMonths");
        btPrepayMonths.appendChild(doc.createTextNode(entity.getBargainTermsPrepayMonths()));
        Element hasGrace = doc.createElement("HasGracePeriod");
        hasGrace.appendChild(doc.createTextNode(String.valueOf(entity.getBargainTermsHasGracePeriod())));
        Element btDeposit = doc.createElement("Deposit");
        btDeposit.appendChild(doc.createTextNode(entity.getBargainTermsDeposit()));
        Element btClientFee = doc.createElement("ClientFee");
        btClientFee.appendChild(doc.createTextNode(entity.getBargainTermsClientFee()));
        Element btSecurityDeposit = doc.createElement("SecurityDeposit");
        btSecurityDeposit.appendChild(doc.createTextNode(entity.getBargainTermsSecurityDeposit()));
        Element agentFee = doc.createElement("AgentFee");
        agentFee.appendChild(doc.createTextNode(entity.getBargainTermsAgentFee()));
        bargainTerms.appendChild(leaseTermType);
        bargainTerms.appendChild(minLeaseTerm);
        bargainTerms.appendChild(btPrepayMonths);
        bargainTerms.appendChild(hasGrace);
        bargainTerms.appendChild(btDeposit);
        bargainTerms.appendChild(btClientFee);
        bargainTerms.appendChild(btSecurityDeposit);
        bargainTerms.appendChild(agentFee);

        Element agentBonus = doc.createElement("AgentBonus");
        Element abValue = doc.createElement("Value");
        abValue.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusValue()));
        Element abPaymentType = doc.createElement("PaymentType");
        abPaymentType.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusPaymentType()));
        Element abCurrency = doc.createElement("Currency");
        abCurrency.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusCurrency()));
        agentBonus.appendChild(abValue);
        agentBonus.appendChild(abPaymentType);
        agentBonus.appendChild(abCurrency);
        bargainTerms.appendChild(agentBonus);
        object.appendChild(bargainTerms);

        rootElement.appendChild(object);

        doc.replaceChild(rootElement, rootElement);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(cianFeed);

        transformer.transform(source, result);
    }

    public void CianSaleBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        File cianFeed = new File("cianFeed" + dateFormat.format(date) + ".xml");

        if (cianFeed.exists()) {
            Document doc = docBuilder.parse(cianFeed);
            Add2CianSaleBuildingXML(cianFeed, doc, entity, countAvailablePremium);
            return;
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("feed");
        doc.appendChild(rootElement);
        //feed version
        Element feedVersion = doc.createElement("feed_version");
        feedVersion.appendChild(doc.createTextNode("2"));
        rootElement.appendChild(feedVersion);
        Element object = doc.createElement("object");
        rootElement.appendChild(object);

        if (entity.getCategoryBuilding() == null || entity.getCategoryBuilding().isEmpty()) {
            throw new AbstractException("Building category can't be null");
        }
        Element category = doc.createElement("Category");
        category.appendChild(doc.createTextNode(entity.getCategoryBuilding()));
        object.appendChild(category);

        Element auction = doc.createElement("Auction");
        Element bet = doc.createElement("Bet");
        bet.appendChild(doc.createTextNode(entity.getMainAuctionBet()));
        auction.appendChild(bet);
        object.appendChild(auction);

        Element externalId = doc.createElement("ExternalId");
        externalId.appendChild(doc.createTextNode(String.valueOf(entity.getId())));
        object.appendChild(externalId);

        Element description = doc.createElement("Description");
        description.appendChild(doc.createTextNode(entity.getMainDescription()));
        object.appendChild(description);

        Element address = doc.createElement("Address");
        address.appendChild(doc.createTextNode(entity.getMainAddress()));
        object.appendChild(address);

        Element coordinates = doc.createElement("Coordinates");
        Element lat = doc.createElement("Lat");
        Element lng = doc.createElement("Lng");
        lat.appendChild(doc.createTextNode(entity.getMainCoordinatesLat()));
        lng.appendChild(doc.createTextNode(entity.getMainCoordinatesLng()));
        coordinates.appendChild(lat);
        coordinates.appendChild(lng);
        object.appendChild(coordinates);

        Element cadastralNumber = doc.createElement("CadastralNumber");
        cadastralNumber.appendChild(doc.createTextNode(entity.getMainCadastralNumber()));
        object.appendChild(cadastralNumber);

        Element phones = doc.createElement("Phones");
        if (!entity.getMainPhonesSchema().isEmpty()) {
            for (PhoneJson phone : entity.getMainPhonesSchema()) {
                Element phoneSchema = doc.createElement("PhoneSchema");
                Element countryCode = doc.createElement("CountryCode");
                Element number = doc.createElement("Number");
                countryCode.appendChild(doc.createTextNode(phone.getCountryCode()));
                number.appendChild(doc.createTextNode(phone.getCountryCode()));
                phoneSchema.appendChild(countryCode);
                phoneSchema.appendChild(number);
                phones.appendChild(phoneSchema);
            }
        }
        object.appendChild(phones);

        Element highway = doc.createElement("Highway");
        Element id = doc.createElement("Id");
        Element distance = doc.createElement("Distance");
        id.appendChild(doc.createTextNode(entity.getMainHigwayId()));
        distance.appendChild(doc.createTextNode(entity.getMainHighwayDistance()));
        highway.appendChild(id);
        highway.appendChild(distance);
        object.appendChild(highway);

        Element higways = doc.createElement("Highways");
        if (!entity.getMainHighwaySchema().isEmpty()) {
            for (HighwayJson highways : entity.getMainHighwaySchema()) {
                Element highwayInfoSchema = doc.createElement("HighwayInfoSchema");
                Element idHighway = doc.createElement("Id");
                Element distanceHigway = doc.createElement("Distance");
                idHighway.appendChild(doc.createTextNode(highways.getId()));
                distanceHigway.appendChild(doc.createTextNode(highways.getDistance()));
                highwayInfoSchema.appendChild(idHighway);
                highwayInfoSchema.appendChild(distanceHigway);
                higways.appendChild(highwayInfoSchema);
            }
        }
        object.appendChild(higways);

        Element undegrounds = doc.createElement("Undergrounds");
        if (!entity.getMainUndegroundsSchema().isEmpty()) {
            for (UndegroundJson undeground : entity.getMainUndegroundsSchema()) {
                Element undergroundInfoSchema = doc.createElement("UndergroundInfoSchema");
                Element idUndeground = doc.createElement("Id");
                Element timeUndeground = doc.createElement("Time");
                Element transportType = doc.createElement("TransportType");
                idUndeground.appendChild(doc.createTextNode(undeground.getId()));
                timeUndeground.appendChild(doc.createTextNode(undeground.getTime()));
                transportType.appendChild(doc.createTextNode(undeground.getTransportType()));
                undergroundInfoSchema.appendChild(idUndeground);
                undergroundInfoSchema.appendChild(timeUndeground);
                undergroundInfoSchema.appendChild(transportType);
                undegrounds.appendChild(undergroundInfoSchema);
            }
        }
        object.appendChild(undegrounds);

        Element booking = doc.createElement("Booking");
        Element status = doc.createElement("Status");
        status.appendChild(doc.createTextNode(entity.getMainBookingStatus()));
        booking.appendChild(status);
        object.appendChild(booking);

        Element coonditionType = doc.createElement("ConditionType");
        coonditionType.appendChild(doc.createTextNode(entity.getConditionType()));
        object.appendChild(coonditionType);

        Element subAgent = doc.createElement("SubAgent");
        Element sEmail = doc.createElement("Email");
        Element sPhone = doc.createElement("Phone");
        Element fName = doc.createElement("FirstName");
        Element lName = doc.createElement("LastName");
        Element sAvatar = doc.createElement("AvatarUrl");
        sEmail.appendChild(doc.createTextNode(entity.getMainSubagentEmail()));
        sPhone.appendChild(doc.createTextNode(entity.getMainSubagentPhone()));
        fName.appendChild(doc.createTextNode(entity.getMainSubagentFirstName()));
        lName.appendChild(doc.createTextNode(entity.getMainSubagentLastName()));
        sAvatar.appendChild(doc.createTextNode(entity.getMainSubagentAvatar()));
        subAgent.appendChild(sEmail);
        subAgent.appendChild(sPhone);
        subAgent.appendChild(fName);
        subAgent.appendChild(lName);
        subAgent.appendChild(sAvatar);
        object.appendChild(subAgent);

        Element layout = doc.createElement("Layout");
        layout.appendChild(doc.createTextNode(entity.getLayout()));
        object.appendChild(layout);

        Element lPhoto = doc.createElement("LayoutPhoto");
        Element lPhotoUrl = doc.createElement("FullUrl");
        Element lIsDefault = doc.createElement("IsDefault");
        lPhotoUrl.appendChild(doc.createTextNode(entity.getMainLayoutphotoUrl()));
        lIsDefault.appendChild(doc.createTextNode(String.valueOf(entity.getMainLayoutphotoIsDefault())));
        lPhoto.appendChild(lPhotoUrl);
        lPhoto.appendChild(lIsDefault);
        object.appendChild(lPhoto);

        Element photos = doc.createElement("Photos");
        if (!entity.getMainPhotoSchema().isEmpty()) {
            for (PhotosJson photo : entity.getMainPhotoSchema()) {
                Element photoSchema = doc.createElement("PhotoSchema");
                Element fullUrl = doc.createElement("FullUrl");
                Element isDefault = doc.createElement("IsDefault");
                fullUrl.appendChild(doc.createTextNode(photo.getFullUrl()));
                isDefault.appendChild(doc.createTextNode(String.valueOf(photo.getIsDefault())));
                photoSchema.appendChild(fullUrl);
                photoSchema.appendChild(isDefault);
                photos.appendChild(photoSchema);
            }
        }
        object.appendChild(photos);

        Element hasFurniture = doc.createElement("HasFurniture");
        hasFurniture.appendChild(doc.createTextNode(String.valueOf(entity.getHasFurniture())));
        object.appendChild(hasFurniture);

        Element inputType = doc.createElement("InputType");
        inputType.appendChild(doc.createTextNode(entity.getInputType()));
        object.appendChild(inputType);

        Element availableFrom = doc.createElement("AvailableFrom");
        availableFrom.appendChild(doc.createTextNode(entity.getAvailableFrom()));
        object.appendChild(availableFrom);

        Element taxNumber = doc.createElement("TaxNumber");
        taxNumber.appendChild(doc.createTextNode(entity.getTaxNumber()));
        object.appendChild(taxNumber);

        Element isInHiddenBase = doc.createElement("IsInHiddenBase");
        isInHiddenBase.appendChild(doc.createTextNode(String.valueOf(entity.getIsInHiddenBase())));
        object.appendChild(isInHiddenBase);

        Element videos = doc.createElement("Videos");
        if (!entity.getMainVideoSchema().isEmpty()) {
            for (VideoJson video : entity.getMainVideoSchema()) {
                Element videoSchema = doc.createElement("VideoSchema");
                Element videoUrl = doc.createElement("Url");
                videoUrl.appendChild(doc.createTextNode(video.getUrl()));
                videoSchema.appendChild(videoUrl);
                videos.appendChild(videoSchema);
            }
        }
        object.appendChild(videos);

        if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
            if ((entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("premium") || entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("top3")) && (countAvailablePremium > 0)) {
                Element title = doc.createElement("Title");
                title.appendChild(doc.createTextNode(entity.getTitle()));
                object.appendChild(title);
            }
        }

        Element building = doc.createElement("Building");
        Element nameb = doc.createElement("Name");
        nameb.appendChild(doc.createTextNode(entity.getBuildingName()));
        building.appendChild(nameb);

        if (entity.getBuildingFloorsCount() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building floors count can't be null");
        }
        Element floorsCount = doc.createElement("FloorsCount");
        floorsCount.appendChild(doc.createTextNode(entity.getBuildingFloorsCount()));
        building.appendChild(floorsCount);
        if (entity.getBuildingFloorsCount().isEmpty() || entity.getBuildingTotalArea() == null) {
            throw new RuntimeException("Building totalArea count can't be null");
        }
        Element totalArea = doc.createElement("TotalArea");
        totalArea.appendChild(doc.createTextNode(entity.getBuildingTotalArea()));
        building.appendChild(totalArea);

        Element heatingType = doc.createElement("HeatingType");
        heatingType.appendChild(doc.createTextNode(entity.getBuildingHeatingType()));
        building.appendChild(heatingType);

        Element ceilingHeight = doc.createElement("CeilingHeight");
        ceilingHeight.appendChild(doc.createTextNode(entity.getBuildingCellingHeight()));
        building.appendChild(ceilingHeight);

        Element parking = doc.createElement("Parking");
        Element typeP = doc.createElement("Type");
        typeP.appendChild(doc.createTextNode(entity.getBuildingParkingType()));
        Element placesCount = doc.createElement("PlacesCount");
        placesCount.appendChild(doc.createTextNode(entity.getBuildingParkingPlacesCount()));
        Element priceMounthly = doc.createElement("PriceMonthly");
        priceMounthly.appendChild(doc.createTextNode(entity.getBuildingParkingPriceMonthly()));
        Element pIsFree = doc.createElement("IsFree");
        pIsFree.appendChild(doc.createTextNode(String.valueOf(entity.getBuildingParkingIsFree())));
        parking.appendChild(typeP);
        parking.appendChild(placesCount);
        parking.appendChild(priceMounthly);
        parking.appendChild(pIsFree);
        building.appendChild(parking);

        Element buildingType = doc.createElement("Type");
        buildingType.appendChild(doc.createTextNode(entity.getBuildingType()));
        building.appendChild(buildingType);

        Element houseLine = doc.createElement("HouseLineType");
        houseLine.appendChild(doc.createTextNode(entity.getBuildingHouseLineType()));
        building.appendChild(houseLine);

        Element classType = doc.createElement("ClassType");
        classType.appendChild(doc.createTextNode(entity.getBuildingClassType()));
        building.appendChild(classType);

        Element developer = doc.createElement("Developer");
        developer.appendChild(doc.createTextNode(entity.getBuildingDeveloper()));
        building.appendChild(developer);

        Element managementCompany = doc.createElement("ManagementCompany");
        managementCompany.appendChild(doc.createTextNode(entity.getBuildingManagementCompany()));
        building.appendChild(managementCompany);

        Element ventilationType = doc.createElement("VentilationType");
        ventilationType.appendChild(doc.createTextNode(entity.getBuildingVentilationType()));
        building.appendChild(ventilationType);

        Element conditioningType = doc.createElement("ConditioningType");
        conditioningType.appendChild(doc.createTextNode(entity.getBuildingConditioningType()));
        building.appendChild(conditioningType);

        Element extinguishingSystemType = doc.createElement("ExtinguishingSystemType");
        extinguishingSystemType.appendChild(doc.createTextNode(entity.getBuildingExtinguishingType()));
        building.appendChild(extinguishingSystemType);

        Element extinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypes");
        if (!entity.getBuildingExtinguishingSystemTypesSchema().isEmpty()) {
            for (ExtinguishingSystemTypeJson ext : entity.getBuildingExtinguishingSystemTypesSchema()) {
                Element eExtinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypeEnum");
                eExtinguishingSystemTypes.appendChild(doc.createTextNode(ext.getExtinguishingSystemTypeEnum()));
                extinguishingSystemTypes.appendChild(eExtinguishingSystemTypes);
            }
        }
        building.appendChild(extinguishingSystemTypes);

        Element liftTypes = doc.createElement("LiftTypes");
        if (!entity.getBuildingLiftTypesSchema().isEmpty()) {
            for (LiftTypeJson lift : entity.getBuildingLiftTypesSchema()) {
                Element liftTypeSchema = doc.createElement("LiftTypeSchema");
                Element type = doc.createElement("Type");
                Element additionalType = doc.createElement("AdditionalType");
                Element count = doc.createElement("Count");
                type.appendChild(doc.createTextNode(lift.getType()));
                additionalType.appendChild(doc.createTextNode(lift.getAdditionalType()));
                count.appendChild(doc.createTextNode(lift.getCount()));
                liftTypeSchema.appendChild(type);
                liftTypeSchema.appendChild(additionalType);
                liftTypeSchema.appendChild(count);
                liftTypes.appendChild(liftTypeSchema);
            }
        }
        building.appendChild(liftTypes);

        Element statusType = doc.createElement("StatusType");
        statusType.appendChild(doc.createTextNode(entity.getBuildingStatusType()));
        building.appendChild(statusType);

        object.appendChild(building);

        Element land = doc.createElement("Land");
        Element landArea = doc.createElement("Area");
        landArea.appendChild(doc.createTextNode(entity.getLandArea()));
        land.appendChild(landArea);
        Element landAreaUnit = doc.createElement("AreaUnitType");
        landAreaUnit.appendChild(doc.createTextNode(entity.getLandAreaUnitType()));
        land.appendChild(landAreaUnit);
        Element landType = doc.createElement("Type");
        landType.appendChild(doc.createTextNode(entity.getLandAreaType()));
        land.appendChild(landType);

        object.appendChild(land);

        Element rentByPartsDescription = doc.createElement("RentByPartsDescription");
        rentByPartsDescription.appendChild(doc.createTextNode(entity.getMainRentByPartsDesc()));
        object.appendChild(rentByPartsDescription);

        Element areaParts = doc.createElement("AreaParts");
        if (!entity.getAreaPartsRentByPartsSchema().isEmpty()) {
            for (AreaPartsRentByPartsJson parts : entity.getAreaPartsRentByPartsSchema()) {
                Element rentByPartsSchema = doc.createElement("RentByPartsSchema");
                Element area = doc.createElement("Area");
                area.appendChild(doc.createTextNode(parts.getArea()));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(parts.getPrice()));
                rentByPartsSchema.appendChild(area);
                rentByPartsSchema.appendChild(price);
                areaParts.appendChild(rentByPartsSchema);
            }
        }
        object.appendChild(areaParts);
        Range<Integer> range = Range.between(2, 30);
        if (!entity.getMultiListingSlotsSchema().isEmpty() && range.contains(entity.getMultiListingSlotsSchema().size())) {
            Element multiListingSlots = doc.createElement("MultiListingSlots");
            for (MultiListingSlotsJson multi : entity.getMultiListingSlotsSchema()) {
                if (multi.getArea() == null || multi.getArea().isEmpty()) {
                    throw new RuntimeException("MultiListing Area can't be null");
                }
                if (multi.getPrice() == null || multi.getPrice().isEmpty()) {
                    throw new RuntimeException("MultiListing Price can't be null");
                }
                if (multi.getFloorFrom() == null || multi.getFloorFrom().isEmpty()) {
                    throw new RuntimeException("MultiListing FloorFrom can't be null");
                }
                Element commercialMultiListingSlotSchema = doc.createElement("CommercialMultiListingSlotSchema");
                Element areaCom = doc.createElement("Area");
                Element priceCom = doc.createElement("Price");
                Element floorFromCom = doc.createElement("FloorFrom");
                Element floorToCom = doc.createElement("FloorTo");
                areaCom.appendChild(doc.createTextNode(multi.getArea()));
                priceCom.appendChild(doc.createTextNode(multi.getPrice()));
                floorFromCom.appendChild(doc.createTextNode(multi.getFloorFrom()));
                floorToCom.appendChild(doc.createTextNode(multi.getFloorTo()));
                commercialMultiListingSlotSchema.appendChild(areaCom);
                commercialMultiListingSlotSchema.appendChild(priceCom);
                commercialMultiListingSlotSchema.appendChild(floorFromCom);
                commercialMultiListingSlotSchema.appendChild(floorToCom);
                Element photosCom = doc.createElement("Photos");
                if (!multi.getPhotosUrl().isEmpty()) {
                    for (String photoCom : multi.getPhotosUrl()) {
                        Element commercialMultiListingSlotPhotoSchema = doc.createElement("CommercialMultiListingSlotPhotoSchema");
                        Element urlPhotoCom = doc.createElement("Url");
                        urlPhotoCom.appendChild(doc.createTextNode(photoCom));
                        commercialMultiListingSlotPhotoSchema.appendChild(urlPhotoCom);
                        photosCom.appendChild(commercialMultiListingSlotPhotoSchema);
                    }
                }
                commercialMultiListingSlotSchema.appendChild(photosCom);
                multiListingSlots.appendChild(commercialMultiListingSlotSchema);
            }
            object.appendChild(multiListingSlots);
        }
        if (!entity.getMainPublishTermsIgnore()) {
            Element publisherTerms = doc.createElement("PublishTerms");
            Element terms = doc.createElement("Terms");
            Element publisherTermsSchema = doc.createElement("PublishTermSchema");
            Element services = doc.createElement("Services");
            Element excludedServices = doc.createElement("ExcludedServices");
            if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
                for (PublisherTermsSchemaServicesJson serv : entity.getMainJsonPublisherTermsSchemaServices()) {
                    Element servicesEnum = doc.createElement("ServicesEnum");
                    servicesEnum.appendChild(doc.createTextNode(serv.getServicesEnum()));
                    services.appendChild(servicesEnum);
                }
                publisherTermsSchema.appendChild(services);
            }
            if (!entity.getMainJsonPublisherTermsSchemaExcludedServices().isEmpty()) {
                for (PublisherTermsSchemaExcludedServicesJson excluded : entity.getMainJsonPublisherTermsSchemaExcludedServices()) {
                    Element excludedServicesEnum = doc.createElement("ExcludedServicesEnum");
                    excludedServicesEnum.appendChild(doc.createTextNode(excluded.getExcludedServicesEnum()));
                    excludedServices.appendChild(excludedServicesEnum);
                }
                publisherTermsSchema.appendChild(excludedServices);
            }
            terms.appendChild(publisherTermsSchema);
            publisherTerms.appendChild(terms);
            object.appendChild(publisherTerms);
        }

        Element extraData = doc.createElement("ExtraData");
        Element exHomeOwnerName = doc.createElement("HomeOwnerName");
        Element exHomeOwnerPhone = doc.createElement("HomeOwnerPhone");
        Element exExactAddress = doc.createElement("ExactAddress");
        exHomeOwnerName.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerName()));
        exHomeOwnerPhone.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerPhone()));
        exExactAddress.appendChild(doc.createTextNode(entity.getMainExtraDataExacAddres()));
        extraData.appendChild(exHomeOwnerName);
        extraData.appendChild(exHomeOwnerPhone);
        extraData.appendChild(exExactAddress);

        object.appendChild(extraData);

        Element bargainTerms = doc.createElement("BargainTerms");
        if (entity.getBargainTermsPrice() == null || entity.getBargainTermsPrice().isEmpty()) {
            throw new RuntimeException("BargainTerms Price can't be null");
        }
        Element btPrice = doc.createElement("Price");
        btPrice.appendChild(doc.createTextNode(entity.getBargainTermsPrice()));
        Element btCurrency = doc.createElement("Currency");
        btCurrency.appendChild(doc.createTextNode(entity.getBargainTermsCurrency()));
        if (entity.getBargainTermsVatType() == null || entity.getBargainTermsVatType().isEmpty()) {
            throw new RuntimeException("BargainTerms VatType can't be null");
        }
        Element btVatType = doc.createElement("VatType");
        btVatType.appendChild(doc.createTextNode(entity.getBargainTermsVatType()));
        bargainTerms.appendChild(btPrice);
        bargainTerms.appendChild(btCurrency);
        bargainTerms.appendChild(btVatType);

        Element btContractType = doc.createElement("ContractType");
        btContractType.appendChild(doc.createTextNode(entity.getBargainTermsContractType()));
        bargainTerms.appendChild(btContractType);

        Element agentBonus = doc.createElement("AgentBonus");
        Element abValue = doc.createElement("Value");
        abValue.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusValue()));
        Element abPaymentType = doc.createElement("PaymentType");
        abPaymentType.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusPaymentType()));
        Element abCurrency = doc.createElement("Currency");
        abCurrency.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusCurrency()));
        agentBonus.appendChild(abValue);
        agentBonus.appendChild(abPaymentType);
        agentBonus.appendChild(abCurrency);
        bargainTerms.appendChild(agentBonus);

        object.appendChild(bargainTerms);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(cianFeed);

        transformer.transform(source, result);

    }

    private void Add2CianSaleBuildingXML(File cianFeed, Document doc, BuildingCianEntity entity, Integer countAvailablePremium) throws TransformerException {

        // root elements
        Element rootElement = doc.getDocumentElement();
        Element object = doc.createElement("object");

        if (entity.getCategoryBuilding() == null || entity.getCategoryBuilding().isEmpty()) {
            throw new AbstractException("Building category can't be null");
        }
        Element category = doc.createElement("Category");
        category.appendChild(doc.createTextNode(entity.getCategoryBuilding()));
        object.appendChild(category);

        Element auction = doc.createElement("Auction");
        Element bet = doc.createElement("Bet");
        bet.appendChild(doc.createTextNode(entity.getMainAuctionBet()));
        auction.appendChild(bet);
        object.appendChild(auction);

        Element externalId = doc.createElement("ExternalId");
        externalId.appendChild(doc.createTextNode(String.valueOf(entity.getId())));
        object.appendChild(externalId);

        Element description = doc.createElement("Description");
        description.appendChild(doc.createTextNode(entity.getMainDescription()));
        object.appendChild(description);

        Element address = doc.createElement("Address");
        address.appendChild(doc.createTextNode(entity.getMainAddress()));
        object.appendChild(address);

        Element coordinates = doc.createElement("Coordinates");
        Element lat = doc.createElement("Lat");
        Element lng = doc.createElement("Lng");
        lat.appendChild(doc.createTextNode(entity.getMainCoordinatesLat()));
        lng.appendChild(doc.createTextNode(entity.getMainCoordinatesLng()));
        coordinates.appendChild(lat);
        coordinates.appendChild(lng);
        object.appendChild(coordinates);

        Element cadastralNumber = doc.createElement("CadastralNumber");
        cadastralNumber.appendChild(doc.createTextNode(entity.getMainCadastralNumber()));
        object.appendChild(cadastralNumber);

        Element phones = doc.createElement("Phones");
        if (!entity.getMainPhonesSchema().isEmpty()) {
            for (PhoneJson phone : entity.getMainPhonesSchema()) {
                Element phoneSchema = doc.createElement("PhoneSchema");
                Element countryCode = doc.createElement("CountryCode");
                Element number = doc.createElement("Number");
                countryCode.appendChild(doc.createTextNode(phone.getCountryCode()));
                number.appendChild(doc.createTextNode(phone.getCountryCode()));
                phoneSchema.appendChild(countryCode);
                phoneSchema.appendChild(number);
                phones.appendChild(phoneSchema);
            }
        }
        object.appendChild(phones);

        Element highway = doc.createElement("Highway");
        Element id = doc.createElement("Id");
        Element distance = doc.createElement("Distance");
        id.appendChild(doc.createTextNode(entity.getMainHigwayId()));
        distance.appendChild(doc.createTextNode(entity.getMainHighwayDistance()));
        highway.appendChild(id);
        highway.appendChild(distance);
        object.appendChild(highway);

        Element higways = doc.createElement("Highways");
        if (!entity.getMainHighwaySchema().isEmpty()) {
            for (HighwayJson highways : entity.getMainHighwaySchema()) {
                Element highwayInfoSchema = doc.createElement("HighwayInfoSchema");
                Element idHighway = doc.createElement("Id");
                Element distanceHigway = doc.createElement("Distance");
                idHighway.appendChild(doc.createTextNode(highways.getId()));
                distanceHigway.appendChild(doc.createTextNode(highways.getDistance()));
                highwayInfoSchema.appendChild(idHighway);
                highwayInfoSchema.appendChild(distanceHigway);
                higways.appendChild(highwayInfoSchema);
            }
        }
        object.appendChild(higways);

        Element undegrounds = doc.createElement("Undergrounds");
        if (!entity.getMainUndegroundsSchema().isEmpty()) {
            for (UndegroundJson undeground : entity.getMainUndegroundsSchema()) {
                Element undergroundInfoSchema = doc.createElement("UndergroundInfoSchema");
                Element idUndeground = doc.createElement("Id");
                Element timeUndeground = doc.createElement("Time");
                Element transportType = doc.createElement("TransportType");
                idUndeground.appendChild(doc.createTextNode(undeground.getId()));
                timeUndeground.appendChild(doc.createTextNode(undeground.getTime()));
                transportType.appendChild(doc.createTextNode(undeground.getTransportType()));
                undergroundInfoSchema.appendChild(idUndeground);
                undergroundInfoSchema.appendChild(timeUndeground);
                undergroundInfoSchema.appendChild(transportType);
                undegrounds.appendChild(undergroundInfoSchema);
            }
        }
        object.appendChild(undegrounds);

        Element booking = doc.createElement("Booking");
        Element status = doc.createElement("Status");
        status.appendChild(doc.createTextNode(entity.getMainBookingStatus()));
        booking.appendChild(status);
        object.appendChild(booking);

        Element coonditionType = doc.createElement("ConditionType");
        coonditionType.appendChild(doc.createTextNode(entity.getConditionType()));
        object.appendChild(coonditionType);

        Element subAgent = doc.createElement("SubAgent");
        Element sEmail = doc.createElement("Email");
        Element sPhone = doc.createElement("Phone");
        Element fName = doc.createElement("FirstName");
        Element lName = doc.createElement("LastName");
        Element sAvatar = doc.createElement("AvatarUrl");
        sEmail.appendChild(doc.createTextNode(entity.getMainSubagentEmail()));
        sPhone.appendChild(doc.createTextNode(entity.getMainSubagentPhone()));
        fName.appendChild(doc.createTextNode(entity.getMainSubagentFirstName()));
        lName.appendChild(doc.createTextNode(entity.getMainSubagentLastName()));
        sAvatar.appendChild(doc.createTextNode(entity.getMainSubagentAvatar()));
        subAgent.appendChild(sEmail);
        subAgent.appendChild(sPhone);
        subAgent.appendChild(fName);
        subAgent.appendChild(lName);
        subAgent.appendChild(sAvatar);
        object.appendChild(subAgent);

        Element layout = doc.createElement("Layout");
        layout.appendChild(doc.createTextNode(entity.getLayout()));
        object.appendChild(layout);

        Element lPhoto = doc.createElement("LayoutPhoto");
        Element lPhotoUrl = doc.createElement("FullUrl");
        Element lIsDefault = doc.createElement("IsDefault");
        lPhotoUrl.appendChild(doc.createTextNode(entity.getMainLayoutphotoUrl()));
        lIsDefault.appendChild(doc.createTextNode(String.valueOf(entity.getMainLayoutphotoIsDefault())));
        lPhoto.appendChild(lPhotoUrl);
        lPhoto.appendChild(lIsDefault);
        object.appendChild(lPhoto);

        Element photos = doc.createElement("Photos");
        if (!entity.getMainPhotoSchema().isEmpty()) {
            for (PhotosJson photo : entity.getMainPhotoSchema()) {
                Element photoSchema = doc.createElement("PhotoSchema");
                Element fullUrl = doc.createElement("FullUrl");
                Element isDefault = doc.createElement("IsDefault");
                fullUrl.appendChild(doc.createTextNode(photo.getFullUrl()));
                isDefault.appendChild(doc.createTextNode(String.valueOf(photo.getIsDefault())));
                photoSchema.appendChild(fullUrl);
                photoSchema.appendChild(isDefault);
                photos.appendChild(photoSchema);
            }
        }
        object.appendChild(photos);

        Element hasFurniture = doc.createElement("HasFurniture");
        hasFurniture.appendChild(doc.createTextNode(String.valueOf(entity.getHasFurniture())));
        object.appendChild(hasFurniture);

        Element inputType = doc.createElement("InputType");
        inputType.appendChild(doc.createTextNode(entity.getInputType()));
        object.appendChild(inputType);

        Element availableFrom = doc.createElement("AvailableFrom");
        availableFrom.appendChild(doc.createTextNode(entity.getAvailableFrom()));
        object.appendChild(availableFrom);

        Element taxNumber = doc.createElement("TaxNumber");
        taxNumber.appendChild(doc.createTextNode(entity.getTaxNumber()));
        object.appendChild(taxNumber);

        Element isInHiddenBase = doc.createElement("IsInHiddenBase");
        isInHiddenBase.appendChild(doc.createTextNode(String.valueOf(entity.getIsInHiddenBase())));
        object.appendChild(isInHiddenBase);

        Element videos = doc.createElement("Videos");
        if (!entity.getMainVideoSchema().isEmpty()) {
            for (VideoJson video : entity.getMainVideoSchema()) {
                Element videoSchema = doc.createElement("VideoSchema");
                Element videoUrl = doc.createElement("Url");
                videoUrl.appendChild(doc.createTextNode(video.getUrl()));
                videoSchema.appendChild(videoUrl);
                videos.appendChild(videoSchema);
            }
        }
        object.appendChild(videos);

        if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
            if ((entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("premium") || entity.getMainJsonPublisherTermsSchemaServices().stream().map(PublisherTermsSchemaServicesJson::getServicesEnum).collect(Collectors.toSet()).contains("top3")) && (countAvailablePremium > 0)) {
                Element title = doc.createElement("Title");
                title.appendChild(doc.createTextNode(entity.getTitle()));
                object.appendChild(title);
            }
        }

        Element building = doc.createElement("Building");
        Element nameb = doc.createElement("Name");
        nameb.appendChild(doc.createTextNode(entity.getBuildingName()));
        building.appendChild(nameb);

        if (entity.getBuildingFloorsCount() == null || entity.getBuildingFloorsCount().isEmpty()) {
            throw new RuntimeException("Building floors count can't be null");
        }
        Element floorsCount = doc.createElement("FloorsCount");
        floorsCount.appendChild(doc.createTextNode(entity.getBuildingFloorsCount()));
        building.appendChild(floorsCount);
        if (entity.getBuildingFloorsCount().isEmpty() || entity.getBuildingTotalArea() == null) {
            throw new RuntimeException("Building totalArea count can't be null");
        }
        Element totalArea = doc.createElement("TotalArea");
        totalArea.appendChild(doc.createTextNode(entity.getBuildingTotalArea()));
        building.appendChild(totalArea);

        Element heatingType = doc.createElement("HeatingType");
        heatingType.appendChild(doc.createTextNode(entity.getBuildingHeatingType()));
        building.appendChild(heatingType);

        Element ceilingHeight = doc.createElement("CeilingHeight");
        ceilingHeight.appendChild(doc.createTextNode(entity.getBuildingCellingHeight()));
        building.appendChild(ceilingHeight);

        Element parking = doc.createElement("Parking");
        Element typeP = doc.createElement("Type");
        typeP.appendChild(doc.createTextNode(entity.getBuildingParkingType()));
        Element placesCount = doc.createElement("PlacesCount");
        placesCount.appendChild(doc.createTextNode(entity.getBuildingParkingPlacesCount()));
        Element priceMounthly = doc.createElement("PriceMonthly");
        priceMounthly.appendChild(doc.createTextNode(entity.getBuildingParkingPriceMonthly()));
        Element pIsFree = doc.createElement("IsFree");
        pIsFree.appendChild(doc.createTextNode(String.valueOf(entity.getBuildingParkingIsFree())));
        parking.appendChild(typeP);
        parking.appendChild(placesCount);
        parking.appendChild(priceMounthly);
        parking.appendChild(pIsFree);
        building.appendChild(parking);

        Element buildingType = doc.createElement("Type");
        buildingType.appendChild(doc.createTextNode(entity.getBuildingType()));
        building.appendChild(buildingType);

        Element houseLine = doc.createElement("HouseLineType");
        houseLine.appendChild(doc.createTextNode(entity.getBuildingHouseLineType()));
        building.appendChild(houseLine);

        Element classType = doc.createElement("ClassType");
        classType.appendChild(doc.createTextNode(entity.getBuildingClassType()));
        building.appendChild(classType);

        Element developer = doc.createElement("Developer");
        developer.appendChild(doc.createTextNode(entity.getBuildingDeveloper()));
        building.appendChild(developer);

        Element managementCompany = doc.createElement("ManagementCompany");
        managementCompany.appendChild(doc.createTextNode(entity.getBuildingManagementCompany()));
        building.appendChild(managementCompany);

        Element ventilationType = doc.createElement("VentilationType");
        ventilationType.appendChild(doc.createTextNode(entity.getBuildingVentilationType()));
        building.appendChild(ventilationType);

        Element conditioningType = doc.createElement("ConditioningType");
        conditioningType.appendChild(doc.createTextNode(entity.getBuildingConditioningType()));
        building.appendChild(conditioningType);

        Element extinguishingSystemType = doc.createElement("ExtinguishingSystemType");
        extinguishingSystemType.appendChild(doc.createTextNode(entity.getBuildingExtinguishingType()));
        building.appendChild(extinguishingSystemType);

        Element extinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypes");
        if (!entity.getBuildingExtinguishingSystemTypesSchema().isEmpty()) {
            for (ExtinguishingSystemTypeJson ext : entity.getBuildingExtinguishingSystemTypesSchema()) {
                Element eExtinguishingSystemTypes = doc.createElement("ExtinguishingSystemTypeEnum");
                eExtinguishingSystemTypes.appendChild(doc.createTextNode(ext.getExtinguishingSystemTypeEnum()));
                extinguishingSystemTypes.appendChild(eExtinguishingSystemTypes);
            }
        }
        building.appendChild(extinguishingSystemTypes);

        Element liftTypes = doc.createElement("LiftTypes");
        if (!entity.getBuildingLiftTypesSchema().isEmpty()) {
            for (LiftTypeJson lift : entity.getBuildingLiftTypesSchema()) {
                Element liftTypeSchema = doc.createElement("LiftTypeSchema");
                Element type = doc.createElement("Type");
                Element additionalType = doc.createElement("AdditionalType");
                Element count = doc.createElement("Count");
                type.appendChild(doc.createTextNode(lift.getType()));
                additionalType.appendChild(doc.createTextNode(lift.getAdditionalType()));
                count.appendChild(doc.createTextNode(lift.getCount()));
                liftTypeSchema.appendChild(type);
                liftTypeSchema.appendChild(additionalType);
                liftTypeSchema.appendChild(count);
                liftTypes.appendChild(liftTypeSchema);
            }
        }
        building.appendChild(liftTypes);

        Element statusType = doc.createElement("StatusType");
        statusType.appendChild(doc.createTextNode(entity.getBuildingStatusType()));
        building.appendChild(statusType);

        object.appendChild(building);

        Element land = doc.createElement("Land");
        Element landArea = doc.createElement("Area");
        landArea.appendChild(doc.createTextNode(entity.getLandArea()));
        land.appendChild(landArea);
        Element landAreaUnit = doc.createElement("AreaUnitType");
        landAreaUnit.appendChild(doc.createTextNode(entity.getLandAreaUnitType()));
        land.appendChild(landAreaUnit);
        Element landType = doc.createElement("Type");
        landType.appendChild(doc.createTextNode(entity.getLandAreaType()));
        land.appendChild(landType);

        object.appendChild(land);

        Element rentByPartsDescription = doc.createElement("RentByPartsDescription");
        rentByPartsDescription.appendChild(doc.createTextNode(entity.getMainRentByPartsDesc()));
        object.appendChild(rentByPartsDescription);

        Element areaParts = doc.createElement("AreaParts");
        if (!entity.getAreaPartsRentByPartsSchema().isEmpty()) {
            for (AreaPartsRentByPartsJson parts : entity.getAreaPartsRentByPartsSchema()) {
                Element rentByPartsSchema = doc.createElement("RentByPartsSchema");
                Element area = doc.createElement("Area");
                area.appendChild(doc.createTextNode(parts.getArea()));
                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(parts.getPrice()));
                rentByPartsSchema.appendChild(area);
                rentByPartsSchema.appendChild(price);
                areaParts.appendChild(rentByPartsSchema);
            }
        }
        object.appendChild(areaParts);
        Range<Integer> range = Range.between(2, 30);
        if (!entity.getMultiListingSlotsSchema().isEmpty() && range.contains(entity.getMultiListingSlotsSchema().size())) {
            Element multiListingSlots = doc.createElement("MultiListingSlots");
            for (MultiListingSlotsJson multi : entity.getMultiListingSlotsSchema()) {
                if (multi.getArea() == null || multi.getArea().isEmpty()) {
                    throw new RuntimeException("MultiListing Area can't be null");
                }
                if (multi.getPrice() == null || multi.getPrice().isEmpty()) {
                    throw new RuntimeException("MultiListing Price can't be null");
                }
                if (multi.getFloorFrom() == null || multi.getFloorFrom().isEmpty()) {
                    throw new RuntimeException("MultiListing FloorFrom can't be null");
                }
                Element commercialMultiListingSlotSchema = doc.createElement("CommercialMultiListingSlotSchema");
                Element areaCom = doc.createElement("Area");
                Element priceCom = doc.createElement("Price");
                Element floorFromCom = doc.createElement("FloorFrom");
                Element floorToCom = doc.createElement("FloorTo");
                areaCom.appendChild(doc.createTextNode(multi.getArea()));
                priceCom.appendChild(doc.createTextNode(multi.getPrice()));
                floorFromCom.appendChild(doc.createTextNode(multi.getFloorFrom()));
                floorToCom.appendChild(doc.createTextNode(multi.getFloorTo()));
                commercialMultiListingSlotSchema.appendChild(areaCom);
                commercialMultiListingSlotSchema.appendChild(priceCom);
                commercialMultiListingSlotSchema.appendChild(floorFromCom);
                commercialMultiListingSlotSchema.appendChild(floorToCom);
                Element photosCom = doc.createElement("Photos");
                if (!multi.getPhotosUrl().isEmpty()) {
                    for (String photoCom : multi.getPhotosUrl()) {
                        Element commercialMultiListingSlotPhotoSchema = doc.createElement("CommercialMultiListingSlotPhotoSchema");
                        Element urlPhotoCom = doc.createElement("Url");
                        urlPhotoCom.appendChild(doc.createTextNode(photoCom));
                        commercialMultiListingSlotPhotoSchema.appendChild(urlPhotoCom);
                        photosCom.appendChild(commercialMultiListingSlotPhotoSchema);
                    }
                }
                commercialMultiListingSlotSchema.appendChild(photosCom);
                multiListingSlots.appendChild(commercialMultiListingSlotSchema);
            }
            object.appendChild(multiListingSlots);
        }
        if (!entity.getMainPublishTermsIgnore()) {
            Element publisherTerms = doc.createElement("PublishTerms");
            Element terms = doc.createElement("Terms");
            Element publisherTermsSchema = doc.createElement("PublishTermSchema");
            Element services = doc.createElement("Services");
            Element excludedServices = doc.createElement("ExcludedServices");
            if (!entity.getMainJsonPublisherTermsSchemaServices().isEmpty()) {
                for (PublisherTermsSchemaServicesJson serv : entity.getMainJsonPublisherTermsSchemaServices()) {
                    Element servicesEnum = doc.createElement("ServicesEnum");
                    servicesEnum.appendChild(doc.createTextNode(serv.getServicesEnum()));
                    services.appendChild(servicesEnum);
                }
                publisherTermsSchema.appendChild(services);
            }
            if (!entity.getMainJsonPublisherTermsSchemaExcludedServices().isEmpty()) {
                for (PublisherTermsSchemaExcludedServicesJson excluded : entity.getMainJsonPublisherTermsSchemaExcludedServices()) {
                    Element excludedServicesEnum = doc.createElement("ExcludedServicesEnum");
                    excludedServicesEnum.appendChild(doc.createTextNode(excluded.getExcludedServicesEnum()));
                    excludedServices.appendChild(excludedServicesEnum);
                }
                publisherTermsSchema.appendChild(excludedServices);
            }
            terms.appendChild(publisherTermsSchema);
            publisherTerms.appendChild(terms);
            object.appendChild(publisherTerms);
        }

        Element extraData = doc.createElement("ExtraData");
        Element exHomeOwnerName = doc.createElement("HomeOwnerName");
        Element exHomeOwnerPhone = doc.createElement("HomeOwnerPhone");
        Element exExactAddress = doc.createElement("ExactAddress");
        exHomeOwnerName.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerName()));
        exHomeOwnerPhone.appendChild(doc.createTextNode(entity.getMainExtraDataHomeOwnerPhone()));
        exExactAddress.appendChild(doc.createTextNode(entity.getMainExtraDataExacAddres()));
        extraData.appendChild(exHomeOwnerName);
        extraData.appendChild(exHomeOwnerPhone);
        extraData.appendChild(exExactAddress);

        object.appendChild(extraData);

        Element bargainTerms = doc.createElement("BargainTerms");
        if (entity.getBargainTermsPrice() == null || entity.getBargainTermsPrice().isEmpty()) {
            throw new RuntimeException("BargainTerms Price can't be null");
        }
        Element btPrice = doc.createElement("Price");
        btPrice.appendChild(doc.createTextNode(entity.getBargainTermsPrice()));
        Element btCurrency = doc.createElement("Currency");
        btCurrency.appendChild(doc.createTextNode(entity.getBargainTermsCurrency()));
        if (entity.getBargainTermsVatType() == null || entity.getBargainTermsVatType().isEmpty()) {
            throw new RuntimeException("BargainTerms VatType can't be null");
        }
        Element btVatType = doc.createElement("VatType");
        btVatType.appendChild(doc.createTextNode(entity.getBargainTermsVatType()));
        bargainTerms.appendChild(btPrice);
        bargainTerms.appendChild(btCurrency);
        bargainTerms.appendChild(btVatType);

        Element btContractType = doc.createElement("ContractType");
        btContractType.appendChild(doc.createTextNode(entity.getBargainTermsContractType()));
        bargainTerms.appendChild(btContractType);

        Element agentBonus = doc.createElement("AgentBonus");
        Element abValue = doc.createElement("Value");
        abValue.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusValue()));
        Element abPaymentType = doc.createElement("PaymentType");
        abPaymentType.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusPaymentType()));
        Element abCurrency = doc.createElement("Currency");
        abCurrency.appendChild(doc.createTextNode(entity.getBargainTermsAgentBonusCurrency()));
        agentBonus.appendChild(abValue);
        agentBonus.appendChild(abPaymentType);
        agentBonus.appendChild(abCurrency);
        bargainTerms.appendChild(agentBonus);
        object.appendChild(bargainTerms);

        rootElement.appendChild(object);

        doc.replaceChild(rootElement, rootElement);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(cianFeed);

        transformer.transform(source, result);
    }
}
