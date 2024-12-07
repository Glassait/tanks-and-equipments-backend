package com.glassait.tanks_and_equipments.tanks.details.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tank_detail")
public class TankDetailModel {
    @Id
    @Description("The id of the tank")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Description("The description of the tank")
    @NotBlank(message = "The skill's description must be not blank")
    @NotEmpty(message = "The skill's description must be not empty")
    @NotNull(message = "The skill's description is mandatory")
    private String description;

    @Size(message = "Need at least one configuration", min = 1)
    @NotNull(message = "The configuration of the tank can't be null")
    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "tank_id", referencedColumnName = "id")
    private List<TankConfigurationModel> configuration;
}
