package com.practice.cassandra.springdata.jpa.entiy;

import com.practice.cassandra.springdata.jpa.entiy.id.FilmActorId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity
@IdClass(FilmActorId.class)
@Data
public class FilmActor {
    /**
     * actor_id
     */
    @Id
    private Integer actor_id;

    /**
     * film_id
     */
    @Id
    @Column(name="film_id")
    private Integer filmId;

    /**
     * last_update
     */
    private Date last_update;


}
