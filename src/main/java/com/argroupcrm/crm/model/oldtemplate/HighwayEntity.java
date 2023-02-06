package com.argroupcrm.crm.model.oldtemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "highway")
public class HighwayEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "isMainWay")
    private Boolean isMainWay;
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
