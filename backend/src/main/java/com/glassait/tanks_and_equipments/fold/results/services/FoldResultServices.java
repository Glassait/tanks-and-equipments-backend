package com.glassait.tanks_and_equipments.fold.results.services;

import com.glassait.tanks_and_equipments.api.model.FoldResult;
import com.glassait.tanks_and_equipments.shared.configs.HazelcastConfig;
import com.glassait.tanks_and_equipments.fold.results.mappers.FoldResultsMapper;
import com.glassait.tanks_and_equipments.fold.results.repository.FoldResultsRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoldResultServices {
    private static final FoldResultsMapper FOLD_RESULTS_MAPPER = Mappers.getMapper(FoldResultsMapper.class);

    private final FoldResultsRepository foldResultsRepository;

    @Cacheable(HazelcastConfig.FOLD_RESULTS_CACHE_KEY)
    public List<FoldResult> getTanksOverview() {
        return FOLD_RESULTS_MAPPER.convertListFoldResultModelToListFoldResult(foldResultsRepository.getLastResults());
    }
}
