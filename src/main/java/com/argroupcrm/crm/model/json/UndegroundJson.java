package com.argroupcrm.crm.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ogbozoyan
 * @date 12.02.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UndegroundJson implements Serializable {
    private String transportType;
    private String time;
    private String id;
}
