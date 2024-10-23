package com.glassait.tanks_and_equipments.wot.news.mappers;

import com.glassait.tanks_and_equipments.api.model.WotNews;
import com.glassait.tanks_and_equipments.wot.news.models.WotNewsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WotNewsMapper {
    List<WotNews> convertListWotNewsModelToListWotNews(List<WotNewsModel> wotNewsModels);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(target = "tags", expression = "java(List.of(wotNewsModel.getTags().split(\",\")))")
    WotNews convertWotNewsModelToWotNews(WotNewsModel wotNewsModel);
}
