package com.practice.cassandra.springdata.jpa.entiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "film")
@Data
public class Film {

    @Id
    private Integer film_id;

    /**
     * title
     */
    private String title;

    /**
     * description
     */
    private String description;

    /**
     * release_year
     */
    private String release_year;

    /**
     * language_id
     */
    private Integer language_id;

    /**
     * original_language_id
     */
    private Integer original_language_id;

    /**
     * rental_duration
     */
    private Integer rental_duration;

    /**
     * rental_rate
     */
    private BigDecimal rental_rate;

    /**
     * length
     */
    private Integer length;

    /**
     * replacement_cost
     */
    private BigDecimal replacement_cost;

    /**
     * rating
     */
    private String rating;

    /**
     * aries ， deleted scenes ， behind the scenes )
     */
    private String special_features;

    /**
     * last_update
     */
    private Date last_update;


}
