package com.pgcode.clubs.catalog.domain;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClubMapper {
    Club toEntity(ClubDto clubDto);

    ClubDto toDto(Club club);

    Iterable<ClubDto> toDto(Iterable<Club> clubs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    Club partialUpdate(ClubDto clubDto, @MappingTarget Club club);
}