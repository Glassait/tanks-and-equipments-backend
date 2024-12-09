package com.glassait.tanks_and_equipments.wot.news.models;

import com.glassait.tanks_and_equipments.shared.converters.JpaConverterList;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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

import java.util.List;

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
    @NotBlank(message = "The wot news image url must be not blank")
    @NotEmpty(message = "The wot news image url must be not empty")
    @NotNull(message = "The wot news image url is mandatory")
    private String imageUrl;

    @Column(name = "url", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The url of the wot news")
    @NotBlank(message = "The wot news url must be not blank")
    @NotEmpty(message = "The wot news url must be not empty")
    @NotNull(message = "The wot news url is mandatory")
    private String url;

    @Column(name = "tags", nullable = false)
    @Convert(converter = JpaConverterList.class)
    @Description("The tags of the wot news")
    @NotBlank(message = "The wot news tags must be not blank")
    @NotEmpty(message = "The wot news tags must be not empty")
    @NotNull(message = "The wot news tags is mandatory")
    private List<String> tags;
}
