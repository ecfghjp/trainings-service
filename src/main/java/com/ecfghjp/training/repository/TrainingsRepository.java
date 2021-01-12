package com.ecfghjp.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ecfghjp.training.entities.Training;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Long>, JpaSpecificationExecutor<Training> {

}
