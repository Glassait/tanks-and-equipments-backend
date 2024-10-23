package com.glassait.tanks_and_equipments.fold.results.repository;

import com.glassait.tanks_and_equipments.fold.results.models.FoldResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoldResultsRepository extends JpaRepository<FoldResultModel, Integer> {
    @Query("SELECT f FROM FoldResultModel f ORDER BY f.id DESC LIMIT 2")
    List<FoldResultModel> getLastResults();
}
