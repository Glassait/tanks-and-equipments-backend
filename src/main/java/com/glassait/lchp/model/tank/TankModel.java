package com.glassait.lchp.model.tank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tanks")
public class TankModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private int priority;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CrewModel.class)
    @JoinColumn(name = "id", referencedColumnName = "tank_id")
    private CrewModel crewModel;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = SkillModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<SkillModel> skillModel;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ShellModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<ShellModel> shellModel;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = FieldsModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<FieldsModel> fieldsModels;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = DirectiveModel.class)
    @JoinColumn(name = "id", referencedColumnName = "tank_id")
    private DirectiveModel directiveModel;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = EquipmentModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<EquipmentModel> equipmentModel;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ConsumableModel.class)
    @JoinColumn(name = "id", referencedColumnName = "tank_id")
    private ConsumableModel consumableModel;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = LinkModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<LinkModel> linkModels;
}
