package club.ddrillini.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import club.ddrillini.api.model.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();
}
