package com.practice.cassandra.springdata.jpa;

import com.practice.cassandra.springdata.jpa.entiy.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
}
