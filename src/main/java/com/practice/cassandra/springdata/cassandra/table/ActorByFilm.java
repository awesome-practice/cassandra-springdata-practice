package com.practice.cassandra.springdata.cassandra.table;

import com.practice.cassandra.springdata.cassandra.table.key.ActorByFilmKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorByFilm {

    @PrimaryKey
    private ActorByFilmKey key;

    /**
     * first_name
     */
    private String first_name;

    /**
     * last_name
     */
    private String last_name;

    /**
     * last_update
     */
    private Date last_update;
}
