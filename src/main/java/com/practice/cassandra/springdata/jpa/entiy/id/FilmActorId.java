package com.practice.cassandra.springdata.jpa.entiy.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorId implements Serializable {
    private Integer actor_id;

    private Integer filmId;

}
