package com.transturkish.backend.repository;

import com.transturkish.backend.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;

// Permite realizar operaciones CRUD con las palabras
public interface PalabraRepository
        extends JpaRepository<Palabra, Long> {
}
