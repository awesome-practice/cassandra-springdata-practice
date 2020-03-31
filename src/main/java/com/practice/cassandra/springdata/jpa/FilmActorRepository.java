package com.practice.cassandra.springdata.jpa;

import com.practice.cassandra.springdata.jpa.entiy.FilmActor;
import com.practice.cassandra.springdata.jpa.entiy.id.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmActorRepository extends JpaRepository<FilmActor,FilmActorId> {


    List<FilmActor> findByFilmId(Integer filmId);
}
