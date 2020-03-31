package com.practice.cassandra.springdata.cassandra;

import com.practice.cassandra.springdata.cassandra.table.FilmSummary;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FilmSummaryRepository extends CassandraRepository<FilmSummary,Integer> {
}
