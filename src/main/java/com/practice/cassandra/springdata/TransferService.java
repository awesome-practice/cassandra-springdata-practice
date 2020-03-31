package com.practice.cassandra.springdata;

import com.practice.cassandra.springdata.cassandra.ActorByFilmRepository;
import com.practice.cassandra.springdata.cassandra.FilmSummaryRepository;
import com.practice.cassandra.springdata.cassandra.table.ActorByFilm;
import com.practice.cassandra.springdata.cassandra.table.FilmSummary;
import com.practice.cassandra.springdata.cassandra.table.key.ActorByFilmKey;
import com.practice.cassandra.springdata.jpa.ActorRepository;
import com.practice.cassandra.springdata.jpa.FilmActorRepository;
import com.practice.cassandra.springdata.jpa.FilmRepository;
import com.practice.cassandra.springdata.jpa.entiy.Actor;
import com.practice.cassandra.springdata.jpa.entiy.Film;
import com.practice.cassandra.springdata.jpa.entiy.FilmActor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TransferService {

    private final ActorRepository actorRepository;
    private final FilmActorRepository filmActorRepository;
    private final FilmRepository filmRepository;

    private final ActorByFilmRepository actorByFilmRepository;
    private final FilmSummaryRepository filmSummaryRepository;

    public TransferService(ActorRepository actorRepository, FilmActorRepository filmActorRepository, FilmRepository filmRepository, ActorByFilmRepository actorByFilmRepository, FilmSummaryRepository filmSummaryRepository) {
        this.actorRepository = actorRepository;
        this.filmActorRepository = filmActorRepository;
        this.filmRepository = filmRepository;
        this.actorByFilmRepository = actorByFilmRepository;
        this.filmSummaryRepository = filmSummaryRepository;
    }


    public void transfer() {
        List<Film> films;
        int page = 0;
        int size = 20;
        int totalPages;
        do {
            Page<Film> filmPage = filmRepository.findAll(PageRequest.of(page, size));
            totalPages = filmPage.getTotalPages();//1-based, because total is not 0-based. only does a status variable exist 1-based or 0-based
            films = filmPage.getContent();

            doTransfer(films);

        } while (page++ < totalPages);

    }

    private void doTransfer(List<Film> films) {
        for (Film film : films) {
            Integer film_id = film.getFilm_id();
            FilmSummary filmSum = FilmSummary.builder().film_id(film_id).title(film.getTitle()).description(film.getDescription()).release_year(film.getRelease_year()).build();
            if (!filmSummaryRepository.findById(film_id).isPresent()) {
                filmSummaryRepository.save(filmSum);
            }
            List<FilmActor> filmActors = filmActorRepository.findByFilmId(film_id);
            for (FilmActor filmActor : filmActors) {
                Integer actor_id = filmActor.getActor_id();
                Optional<Actor> actorOptional = actorRepository.findById(actor_id);
                if (!actorOptional.isPresent()) {
                    continue;
                }
                Actor actor = actorOptional.get();
                ActorByFilmKey key = new ActorByFilmKey(film_id, actor_id);
                ActorByFilm row = ActorByFilm.builder()
                        .key(key)
                        .first_name(actor.getFirst_name())
                        .last_name(actor.getLast_name())
                        .last_update(new Date())
                        .build();
                if (!actorByFilmRepository.findById(key).isPresent()) {
                    actorByFilmRepository.save(row);
                }
            }


        }
    }
}
