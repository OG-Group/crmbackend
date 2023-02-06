package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "highway_cian")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighwayCianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "cityid")
    private Integer cityid;
    @Column(name = "cityname")
    private String cityname;
    @Column(name = "highway_name")
    private String highwayName;
    @Column(name = "higway_id")
    private String higwayId;
}
