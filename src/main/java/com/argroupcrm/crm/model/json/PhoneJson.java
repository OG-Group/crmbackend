package com.argroupcrm.crm.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 11.02.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneJson implements Serializable {
    private String countryCode;
    private String countryNumber;
}
