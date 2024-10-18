package com.glassait.tanks_and_equipments.wot.news.models;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wot_news")
public class WotNewsModel {
    @Id
    @Column(name = "id")
    @Description("The generated id of the news")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The title of the wot news")
    @NotBlank(message = "The wot news title must be not blank")
    @NotEmpty(message = "The wot news title must be not empty")
    @NotNull(message = "The wot news title is mandatory")
    private String title;

    @Column(name = "image_url", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The image url of the wot news")
    @NotBlank(message = "The wot news image_url must be not blank")
    @NotEmpty(message = "The wot news image_url must be not empty")
    @NotNull(message = "The wot news image_url is mandatory")
    private String imageUrl;

    @Column(name = "tags", nullable = false)
    @Description("The tags of the wot news")
    @NotBlank(message = "The wot news tags must be not blank")
    @NotEmpty(message = "The wot news tags must be not empty")
    @NotNull(message = "The wot news tags is mandatory")
    private String tags;
}
