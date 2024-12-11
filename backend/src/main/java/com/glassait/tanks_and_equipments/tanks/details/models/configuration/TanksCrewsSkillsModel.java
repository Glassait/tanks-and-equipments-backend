package com.glassait.tanks_and_equipments.tanks.details.models.configuration;

import com.glassait.tanks_and_equipments.tanks.details.models.base.SkillsModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tanks_crews_skills")
public class TanksCrewsSkillsModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the crews skills")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = SkillsModel.class)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @Description("The skill of the crew member")
    @NotNull(message = "The crew member skill cannot be null")
    private SkillsModel skill;

    @Positive(message = "The level of a skill cannot be negative")
    @Range(message = "The level of a skill need to be between 1 and 6", min = 1, max = 6)
    @Column(nullable = false)
    @Description("The level of the skill")
    @NotNull(message = "The level of the skill cannot be null")
    private int level;
}
