package com.glassait.tanks_and_equipments.wot.news.mappers;

import com.glassait.tanks_and_equipments.api.model.WotNews;
import com.glassait.tanks_and_equipments.wot.news.models.WotNewsModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WotNewsMapper {
    List<WotNews> convertListWotNewsModelToListWotNews(List<WotNewsModel> wotNewsModels);

    WotNews convertWotNewsModelToWotNews(WotNewsModel wotNewsModel);
}
