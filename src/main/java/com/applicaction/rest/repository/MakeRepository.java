package com.applicaction.rest.repository;

import com.applicaction.rest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends CrudRepository<Maker,Long> {
}
