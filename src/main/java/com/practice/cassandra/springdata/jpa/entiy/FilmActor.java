package com.practice.cassandra.springdata.jpa.entiy;

import com.practice.cassandra.springdata.jpa.entiy.id.FilmActorId;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film_actor")
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
