package com.glassait.lchp.model.tank;

import jakarta.persistence.*;
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
