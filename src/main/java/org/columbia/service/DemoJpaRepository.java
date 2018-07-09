package org.columbia.service;

import org.columbia.entity.TextEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemoJpaRepository extends CrudRepository<TextEntity, UUID> { }
