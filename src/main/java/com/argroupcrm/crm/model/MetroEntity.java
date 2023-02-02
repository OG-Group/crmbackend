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
@Table(name = "metro", schema = "public", catalog = "argroupcrm")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetroEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "time")
    private Integer time;
    @Column(name = "isMainWay")
    private Boolean isMainWay;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "building_metro",
//            joinColumns = @JoinColumn(name = "metro_id", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID")
//    )
//    private List<BuildingEntity> metroBuilding;
}
