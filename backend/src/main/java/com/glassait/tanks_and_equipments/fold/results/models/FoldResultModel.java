package com.glassait.tanks_and_equipments.fold.results.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "results")
@Description("This table hold all the information about the competitive result of the clan")
public class FoldResultModel {
    @Id
    @Column(name = "id")
    @Description("The generated id of the results")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The description of the result")
    @NotBlank(message = "The description must be not blank")
    @NotEmpty(message = "The description must be not empty")
    @NotNull(message = "The description is mandatory")
    private String description;

    @Column(name = "image_url", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The image url of the result")
    @NotBlank(message = "The image url must be not blank")
    @NotEmpty(message = "The image url must be not empty")
    @NotNull(message = "The image url is mandatory")
    private String imageUrl;

    @Column(name = "tag", nullable = false)
    @Description("The tag of the result")
    @NotBlank(message = "The tags must be not blank")
    @NotEmpty(message = "The tags must be not empty")
    @NotNull(message = "The tags is mandatory")
    private String tag;
}
