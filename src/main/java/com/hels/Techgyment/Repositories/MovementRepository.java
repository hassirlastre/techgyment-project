package com.hels.Techgyment.Repositories;

import com.hels.Techgyment.Entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
