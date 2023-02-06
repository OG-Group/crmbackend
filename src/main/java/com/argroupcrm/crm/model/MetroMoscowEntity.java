package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "metro_moscow")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetroMoscowEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
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