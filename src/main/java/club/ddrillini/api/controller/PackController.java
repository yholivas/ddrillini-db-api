package club.ddrillini.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import club.ddrillini.api.model.Pack;
import club.ddrillini.api.repository.PackRepository;
import club.ddrillini.api.repository.SongRepository;

@RestController
@RequestMapping(value = "/api/packs")
public class PackController {
    @Autowired
    private PackRepository repository;

    @Autowired
    private SongRepository songRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pack> getPacks() {
        List<Pack> packs = repository.findAll();
        for (Pack pack: packs) {
            pack.songCount = songRepository.countByPackId(pack.getId());
        }
        return packs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pack getPack(@PathVariable("id") long id) {
        return repository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPack(@RequestBody Pack newPack) {
        repository.save(newPack);
    }
}
