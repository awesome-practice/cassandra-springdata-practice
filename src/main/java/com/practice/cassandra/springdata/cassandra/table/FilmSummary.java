package com.practice.cassandra.springdata.cassandra.table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmSummary {

    @PrimaryKey
    private Integer film_id;

    /**
     * title
     */
//    @Column("title")
    private String title;

    /**
     * description
     */
    private String description;

    /**
     * release_year
     */
    private String release_year;

}
