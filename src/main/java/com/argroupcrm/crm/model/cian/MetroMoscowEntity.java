package com.argroupcrm.crm.model.cian;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "metro_moscow")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetroMoscowEntity extends AbstractEntity {
    @Basic
    @Column(name = "id_station")
    private Integer idStation;
    @Basic
    @Column(name = "station")
    private String station;
    @Basic
    @Column(name = "line")
    private String line;
    @Basic
    @Column(name = "color")
    private String color;
}