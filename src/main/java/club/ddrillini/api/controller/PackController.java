/*
 * Copyright 2019 Daniel Olivas
 * This file is part of the DDRIllini Online DB API.

 * The DDRIllini Online DB API is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * The DDRIllini Online DB API is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See
 * the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with The DDRIllini Online DB API. If not, see
 * <https://www.gnu.org/licenses/>.
 */

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
