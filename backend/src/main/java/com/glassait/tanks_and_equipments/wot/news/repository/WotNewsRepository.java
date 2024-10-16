package com.glassait.tanks_and_equipments.wot.news.repository;

import com.glassait.tanks_and_equipments.wot.news.models.WotNewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WotNewsRepository extends JpaRepository<WotNewsModel, Integer> {
    @Query("SELECT w FROM WotNewsModel w ORDER BY w.id DESC LIMIT 8")
    List<WotNewsModel> getLastNews();
}
