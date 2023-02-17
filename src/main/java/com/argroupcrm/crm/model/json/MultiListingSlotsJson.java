package com.argroupcrm.crm.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ogbozoyan
 * @date 12.02.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiListingSlotsJson implements Serializable {
    private String area;
    private String price;
    private String floorFrom;
    private String floorTo;
    private String priceType;
    private String paymentPeriod;
    private List<String> photosUrl;
}
