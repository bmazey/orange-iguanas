package org.columbia.service;

import org.columbia.dto.TextDto;
import org.columbia.dto.TextIdDto;
import org.columbia.entity.TextEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DemoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DemoJpaRepository repository;

    /**
     * Here we'll use our JPA repository methods ...
     * @param id
     * @return
     */

    public TextEntity getTextByID(UUID id) {
        return repository.findById(id).get();
    }

    public TextEntity createText(TextEntity text) {
        repository.save(text);
        return text;
    }

    public TextEntity convertTextDtoToTextEntity(TextDto text) {
        TextEntity entity = modelMapper.map(text, TextEntity.class);
        return entity;
    }

    public TextIdDto convertTextEntityToTextIdDto(TextEntity entity) {
        TextIdDto dto = modelMapper.map(entity, TextIdDto.class);
        return dto;
    }

}
