package com.glassait.equipmentTanks.model.tank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fields")
public class FieldsModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "level")
    private int level;

    @Column(name = "left-name")
    private String leftName;

    @Column(name = "left-image")
    private String leftImage;

    @Column(name = "left-active")
    private int leftActive;

    @Column(name = "right-name")
    private String rightName;

    @Column(name = "right-image")
    private String rightImage;

    @Column(name = "right-active")
    private int rightActive;
}
