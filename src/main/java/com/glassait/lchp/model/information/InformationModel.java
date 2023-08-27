package com.glassait.lchp.model.information;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "information")
public class InformationModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text", length = 520)
    private String text;

    @Column(name = "url")
    private String url;

    @Column(name = "text_url")
    private String textUrl;
}
