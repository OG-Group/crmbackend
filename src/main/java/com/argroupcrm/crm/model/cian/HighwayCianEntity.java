package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "highway_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighwayCianEntity extends AbstractEntity {
    @Column(name = "cityid")
    private Integer cityid;
    @Column(name = "cityname")
    private String cityname;
    @Column(name = "highway_name")
    private String highwayName;
    @Column(name = "higway_id")
    private String higwayId;
}
