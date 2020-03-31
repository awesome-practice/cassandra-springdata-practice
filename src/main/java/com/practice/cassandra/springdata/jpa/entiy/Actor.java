package com.practice.cassandra.springdata.jpa.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Actor {

    @Id
    private Integer actor_id;
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
