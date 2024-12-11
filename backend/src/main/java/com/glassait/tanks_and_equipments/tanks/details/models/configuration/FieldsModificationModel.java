package com.glassait.tanks_and_equipments.tanks.details.models.configuration;

import com.glassait.tanks_and_equipments.shared.converters.JpaConverterList;
import com.glassait.tanks_and_equipments.tanks.details.models.base.FieldsModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "tanks_fields_modification")
@Description("This table hold all the field modification for the tank")
public class FieldsModificationModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the consumable")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Description("The level of the field modification")
    @Min(value = 2, message = "The level of a field modification cannot be lower than 2")
    @Max(value = 8, message = "The level of a field modification cannot be higher than 8")
    @Positive(message = "The level of a field modification need to be positive")
    private int level;

    @Column(nullable = false)
    @Convert(converter = JpaConverterList.class)
    @Description("The names of both side, separated by a comma ','")
    @NotNull(message = "The names of both side of the field modification cannot be null")
    private List<String> names;

    @Column()
    @Description("Define the active side of the field modification (left, right or none = null)")
    private String activeSide;

    @OneToOne(cascade = CascadeType.DETACH, targetEntity = FieldsModel.class, optional = false)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @Description("The left field modification of the row")
    @NotNull(message = "The left field modification cannot be null")
    private FieldsModel leftField;

    @OneToOne(cascade = CascadeType.DETACH, targetEntity = FieldsModel.class, optional = false)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @Description("The right field modification of the row")
    @NotNull(message = "The right field modification cannot be null")
    private FieldsModel rightField;
}
