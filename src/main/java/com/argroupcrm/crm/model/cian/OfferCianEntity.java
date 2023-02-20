package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ogbozoyan
 * @date 18.02.2023
 */
@Entity
@Table(name = "offer_cian")
@Data
@Builder
@NoArgsConstructor
public class OfferCianEntity extends AbstractEntity {
}
