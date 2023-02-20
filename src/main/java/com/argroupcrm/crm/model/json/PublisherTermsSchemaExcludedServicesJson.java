package com.argroupcrm.crm.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 19.02.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherTermsSchemaExcludedServicesJson implements Serializable {
    private String ExcludedServicesEnum;
}
