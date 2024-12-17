package com.glassait.tanks_and_equipments.tanks.details.models.configuration;

import com.glassait.tanks_and_equipments.tanks.details.models.base.RolesModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tanks_crews_secondary_roles")
@Description("This table hold all secondary role taken by a crew member of a tank")
public class TanksCrewSecondaryRolesModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the tanks crew secondary role")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.DETACH, targetEntity = RolesModel.class)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @Description("The role of the crew member")
    @NotNull(message = "The role of the crew member cannot be null")
    private RolesModel role;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = TanksCrewsSkillsModel.class)
    @JoinColumn(name = "tanks_crews_secondary_id", referencedColumnName = "id")
    @OrderBy("level")
    @Description("The list of skills of the crew member")
    private List<TanksCrewsSkillsModel> skills;
}
