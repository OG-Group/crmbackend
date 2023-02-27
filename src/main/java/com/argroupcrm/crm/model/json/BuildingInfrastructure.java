package com.argroupcrm.crm.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 27.02.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingInfrastructure implements Serializable {
    Boolean HasCarWash, HasBuffet,
            HasCarService, HasCanteen,
            HasCentralReception, HasHotel,
            HasAtm, HasExhibitionAndWarehouseComplex,
            HasPharmacy, HasBankDepartment,
            HasCinema, HasCafe,
            HasMedicalCenter, HasBeautyShop,
            HasStudio, HasNotaryOffice,
            HasPool, HasClothesStudio,
            HasWarehouse, HasPark,
            HasRestaurant, HasFitnessCentre,
            HasSupermarket, HasMinimarket,
            HasShoppingArea, HasConferenceRoom;
}
