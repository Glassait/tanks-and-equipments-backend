package com.glassait.tanks_and_equipments.tanks.details.models.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "directives")
@Description("This table hold all the information for all World of Tanks directives")
public class DirectivesModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the directive")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Description("The World of Tanks name of the directive")
    @NotBlank(message = "The directive's name must be not blank")
    @NotEmpty(message = "The directive's name must be not empty")
    @NotNull(message = "The directive's name is mandatory")
    private String wotName;

    @Column(nullable = false, unique = true)
    @Description("The french name of the directive")
    @NotBlank(message = "The directive's name must be not blank")
    @NotEmpty(message = "The directive's name must be not empty")
    @NotNull(message = "The directive's name is mandatory")
    private String name;
}
