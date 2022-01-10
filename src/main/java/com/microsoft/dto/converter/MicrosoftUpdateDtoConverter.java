package com.microsoft.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.dto.MicrosoftUpdateDto;
import com.microsoft.entity.MicrosoftUpdate;

public class MicrosoftUpdateDtoConverter implements DtoConverter<MicrosoftUpdateDto, MicrosoftUpdate> {

    @Override
    public MicrosoftUpdateDto toDto(MicrosoftUpdate entity) {
	MicrosoftUpdateDto microsoftUpdateDto = new MicrosoftUpdateDto();
	microsoftUpdateDto.id = entity.getId();
	microsoftUpdateDto.idMicrosoftUpdate = entity.getIdMicrosoftUpdate();
	microsoftUpdateDto.alias = entity.getAlias();
	microsoftUpdateDto.documentTitle = entity.getDocumentTitle();
	microsoftUpdateDto.severity = entity.getSeverity();
	microsoftUpdateDto.initialReleaseDate = entity.getInitialReleaseDate();
	microsoftUpdateDto.currentReleaseDate = entity.getCurrentReleaseDate();
	microsoftUpdateDto.cvrfUrl = entity.getCvrfUrl();

	return microsoftUpdateDto;
    }

    @Override
    public List<MicrosoftUpdateDto> entityListToDto(List<MicrosoftUpdate> entityList) {

	List<MicrosoftUpdateDto> microsoftUpdateDtoList = new ArrayList<MicrosoftUpdateDto>();

	if (entityList == null) {
	    return microsoftUpdateDtoList;
	}

	for (MicrosoftUpdate microsoftUpdate : entityList) {
	    microsoftUpdateDtoList.add(toDto(microsoftUpdate));
	}

	return microsoftUpdateDtoList;
    }

    @Override
    public MicrosoftUpdate toEntity(MicrosoftUpdateDto dto) {
	MicrosoftUpdate microsoftUpdate = new MicrosoftUpdate();
	microsoftUpdate.setId(dto.id);
	microsoftUpdate.setIdMicrosoftUpdate(dto.idMicrosoftUpdate);
	microsoftUpdate.setAlias(dto.alias);
	microsoftUpdate.setDocumentTitle(dto.documentTitle);
	microsoftUpdate.setSeverity(dto.severity);
	microsoftUpdate.setInitialReleaseDate(dto.initialReleaseDate);
	microsoftUpdate.setCurrentReleaseDate(dto.currentReleaseDate);
	microsoftUpdate.setCvrfUrl(dto.cvrfUrl);

	return microsoftUpdate;
    }
}