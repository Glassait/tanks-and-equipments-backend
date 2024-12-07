package com.glassait.tanks_and_equipments.fold.results.mappers;

import com.glassait.tanks_and_equipments.api.model.FoldResult;
import com.glassait.tanks_and_equipments.fold.results.models.FoldResultModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoldResultsMapper {
    List<FoldResult> convertListFoldResultModelToListFoldResult(List<FoldResultModel> foldResultModels);

    FoldResult convertWotNewsModelToWotNews(FoldResultModel foldResultModel);
}
