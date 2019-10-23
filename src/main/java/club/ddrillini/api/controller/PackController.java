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

@RestController
@RequestMapping(value = "/api")
public class PackController {
    @Autowired
    private PackRepository repository;

    @RequestMapping(value = "/packs", method = RequestMethod.GET)
    public List<Pack> getPacks() {
        return repository.findAll();
    }

    @RequestMapping(value = "/packs/{id}", method = RequestMethod.GET)
    public Pack getPack(@PathVariable("id") long id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/packs", method = RequestMethod.POST)
    public void createPack(@RequestBody Pack newPack) {
        repository.save(newPack);
    }
}
