package com.argroupcrm.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class CrmApplication {

	public static void main(String[] args){
//		Properties outputProperties = new Properties();
//
//		outputProperties.put(javax.xml.transform.OutputKeys.METHOD, "xml");
//		outputProperties.put(javax.xml.transform.OutputKeys.INDENT, "yes");
//		outputProperties.put("{http://xml.apache.org/xslt}indent-amount", "2");
//		outputProperties.put(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
//
//		XMLBuilder2 xmlBuilder2 =
//				XMLBuilder2.create("feed")
//					.e("feed_version").t("2")
//						.up()
//					.e("object")//if more than one do loop
//							.e("Category").t("FlatRent")
//							.up()
//						.e("Auction")
//							.e("Bet").t("10")
//							.up()
//						.up()
//						.e("ExternalId").t("123")
//							.up()
//						.e("Description").t("Текст объявления")
//							.up()
//						.e("Address").t("Москва, ул. Ленина, д. 1")
//							.up()
//						.e("Coordinates")
//							.e("Lat").t("55.755826")
//							.up()
//							.e("Lng").t("37.6173")
//							.up()
//						.up()
//						.e("CadastralNumber").t("77:01:0001001:1234")
//							.up()
//						.e("Phones")
//							.e("PhoneSchema")//if more than one do loop
//								.e("CountryCode").t("+7")
//								.up()
//								.e("Number").t("495")
//								.up()
//							.up()
//						.up()
//						.e("Highway")
//							.e("Id").t("123")
//							.up()
//							.e("Distance").t("10")
//							.up()
//						.up()
//						.e("Highways")//if more than one do loop
//							.e("HighwayInfoSchema")
//								.e("Id").t("123")
//								.up()
//								.e("Distance").t("10")
//								.up()
//							.up()
//						.up()
//						.e("Undergrounds")//if more than one do loop
//							.e("UndergroundInfoSchema")
//								.e("Id").t("10")
//								.up()
//								.e("Time").t("42")
//								.up()
//								.e("TransportType")
//								.up()
//							.up()
//						.up()
//						.e("Booking")
//							.e("Status").t("free")
//							.up()
//						.up()
//						.e("ConditionType").t("cosmeticRepairsRequired")
//						.up()
//						.e("SubAgent")
//							.e("Email").t("email")
//							.up()
//							.e("Phone").t("phone")
//							.up()
//							.e("FirstName").t("firstName")
//							.up()
//							.e("LastName").t("LastName")
//							.up()
//							.e("AvatarUrl").t("url")
//							.up()
//						.up()
//						.e("Layout").t("cabinet")
//						.up()
//						.e("LayoutPhoto")
//							.e("FullUrl").t("url")
//							.up()
//							.e("IsDefault").t("true")
//							.up()
//						.up()
//						.e("Photos")
//							.e("PhotoSchema")//if more than one do loop
//								.e("FullUrl").t("url")
//								.up()
//								.e("IsDefault").t("true")
//								.up()
//							.up()
//						.up()
//						.e("HasFurniture").t("true")
//						.up()
//						.e("InputType").t("commonFromStreet")
//						.up()
//						.e("AvailableFrom").t("String")
//						.up()
//						.e("TaxNumber").t("228")
//						.up()
//						.e("IsInHiddenBase").t("true")
//						.up()
//						.e("Videos")
//							.e("VideoSchema")//if more than one do loop
//								.e("Url").t("url")
//								.up()
//							.up()
//						.up()
//						.e("Title").t("title")
//						.up()
//						.e("Building")
//							.e("Name").t("name")
//							.up()
//							.e("FloorsCount").t("20")
//							.up()
//							.e("TotalArea").t("100")
//							.up()
//							.e("HeatingType").t("autonomous")
//							.up()
//							.e("CeilingHeight").t("4.2")
//							.up()
//							.e("Parking")
//								.e("Type").t("ground")
//								.up()
//								.e("PlacesCount").t("2")
//								.up()
//								.e("PriceMonthly").t("1000")
//								.up()
//								.e("IsFree").t("true")
//								.up()
//							.up()
//							.e("Type").t("administrativeBuilding")
//							.up()
//							.e("HouseLineType").t("first")
//							.up()
//							.e("ClassType").t("a")
//							.up()
//							.e("Developer").t("developer")
//							.up()
//							.e("ManagementCompany").t("managementCompany")
//							.up()
//							.e("VentilationType").t("forced")
//							.up()
//							.e("ConditioningType").t("central")
//							.up()
//							.e("ExtinguishingSystemType").t("alarm")
//							.up()
//							.e("ExtinguishingSystemTypes")//if more than one do loop
//								.e("ExtinguishingSystemTypeEnum").t("alarm")
//								.up()
//							.up()
//							.e("LiftTypes")
//								.e("LiftTypeSchema")//if more than one do loop
//									.e("Type").t("passenger")
//									.up()
//									.e("AdditionalType").t("passenger")
//									.up()
//									.e("Count").t("10")
//									.up()
//								.up()
//							.up()
//							.e("StatusType").t("underConstruction")
//							.up()
//						.up()
//						.e("Land")
//							.e("Area").t("100")
//							.up()
//							.e("AreaUnitType").t("hectar")
//							.up()
//							.e("Type").t("owned")
//							.up()
//						.up()
//						.e("RentByPartsDescription").t("string")
//						.up()
//						.e("AreaParts")
//							.e("RentByPartsSchema")//if more than one do loop
//								.e("Area").t("4.2")
//								.up()
//								.e("Price").t("4.2")
//								.up()
//							.up()
//						.up()
//						.e("MultiListingSlots")
//							.e("CommercialMultiListingSlotSchema")//if more than one do loop
//								.e("Area").t("4")
//								.up()
//								.e("Price").t("200")
//								.up()
//								.e("FloorFrom").t("2")
//								.up()
//								.e("FloorTo").t("4")
//								.up()
//								.e("PriceType").t("all")
//								.up()
//								.e("PaymentPeriod").t("annual")
//								.up()
//								.e("Photos")
//									.e("CommercialMultiListingSlotPhotoSchema")//if more than one do loop
//										.e("Url").t("url")
//										.up()
//									.up()
//								.up()
//							.up()
//						.up()
//						.e("PublishTerms")
//							.e("Terms")
//								.e("PublishTermSchema")
//									.e("Sevices")//if more than one do loop
//										.e("ServicesEnum").t("premium")
//										.up()
//									.up()
//									.e("ExcludedServices")//if more than one do loop
//										.e("ExcludedServicesEnum").t("top3")
//										.up()
//									.up()
//								.up()
//							.up()
//						.up()
//						.e("ExtraData")
//							.e("HomeOwnerName").t("name")
//							.up()
//							.e("HomeOwnerPhone").t("phone")
//							.up()
//							.e("ExactAddress").t("string")
//							.up()
//						.up()
//						.e("BargainTerms")
//							.e("Price").t("100")
//							.up()
//							.e("PriceType").t("all")
//							.up()
//							.e("Currency").t("eur")
//							.up()
//							.e("PaymentPeriod").t("annual")
//							.up()
//							.e("VatType").t("included")
//							.up()
//							.e("LeaseType").t("diricet")
//							.up()
//							.e("IncludedOptions")//if more than one do loop
//								.e("IncludedOptionsEnum").t("furniture")
//								.up()
//							.up()
//							.e("LeaseTermType").t("long")
//							.up()
//							.e("MinLeaseTerm").t("10")
//							.up()
//							.e("PrepayMonths").t("20")
//							.up()
//							.e("HasGracePeriod").t("false")
//							.up()
//							.e("Deposit").t("100")
//							.up()
//							.e("ClientFee").t("1")
//							.up()
//							.e("SecurityDeposit").t("2")
//							.up()
//							.e("AgentFee").t("12")
//							.up()
//							.e("AgentBonus")
//								.e("Value").t("12")
//								.up()
//								.e("PaymentType").t("percent")
//								.up()
//								.e("Currency").t("eur")
//								.up()
//							.up()
//						.up()
//						.up();
//
//		PrintWriter writer = new PrintWriter(new FileOutputStream("test.xml"));
//		xmlBuilder2.toWriter(writer,outputProperties);

		SpringApplication.run(CrmApplication.class, args);

	}
}
