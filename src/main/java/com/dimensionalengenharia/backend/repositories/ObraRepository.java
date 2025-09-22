package com.dimensionalengenharia.backend.repositories;

import com.dimensionalengenharia.backend.models.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, String> {
}
