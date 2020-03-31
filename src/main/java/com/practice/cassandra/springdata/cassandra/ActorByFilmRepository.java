package com.practice.cassandra.springdata.cassandra;

import com.practice.cassandra.springdata.cassandra.table.ActorByFilm;
import com.practice.cassandra.springdata.cassandra.table.key.ActorByFilmKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ActorByFilmRepository extends CassandraRepository<ActorByFilm, ActorByFilmKey> {

}
