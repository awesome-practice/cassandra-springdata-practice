package com.practice.cassandra.springdata.cassandra.table.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@Data
@PrimaryKeyClass
@AllArgsConstructor
@NoArgsConstructor
public class ActorByFilmKey implements Serializable {
    @PrimaryKeyColumn(name ="film_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private Integer film_id;

    @PrimaryKeyColumn(name = "actor_id",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private Integer actor_id;

}
