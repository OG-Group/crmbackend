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
@Table(name = "photo", schema = "public", catalog = "argroupcrm")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "photo")
    private String photo;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "building_photo",
//            joinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "building_id", referencedColumnName = "ID")
//    )
//    private List<BuildingEntity> photoBuilding;

}
