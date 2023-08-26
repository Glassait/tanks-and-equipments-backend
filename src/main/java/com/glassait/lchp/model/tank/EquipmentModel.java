package com.glassait.lchp.model.tank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipments")
public class EquipmentModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first")
    private int first;

    @Column(name = "name")
    private String name;

    @Column(name = "modernized")
    private int modernized;
}
