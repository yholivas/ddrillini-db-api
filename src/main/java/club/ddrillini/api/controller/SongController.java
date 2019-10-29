package club.ddrillini.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import club.ddrillini.api.model.Song;
import club.ddrillini.api.repository.SongRepository;

@RestController
@RequestMapping(value = "/api/songs")
public class SongController {
    @Autowired
    private SongRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Song> getSongs() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Song getSong(@PathVariable("id") long id) {
        return repository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createSong(@RequestBody Song newSong) {
        repository.save(newSong);
    }
}
