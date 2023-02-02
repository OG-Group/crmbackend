package com.argroupcrm.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "highway", schema = "public", catalog = "argroupcrm")
public class HighwayEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "isMainWay")
    private Boolean isMainWay;
    @Basic
    @Column(name = "distance")
    private Integer distance;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "building_highway",
//            joinColumns = @JoinColumn(name = "highway_id", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID")
//    )
//    private List<BuildingEntity> highwayBuilding;

}
