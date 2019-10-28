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

package club.ddrillini.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // no annotation means the properties are mapped to columns with the same name in table
    private String name;
    private String banner;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="pack", cascade = CascadeType.ALL)
    private Set<Song> song;

    protected Pack() {}

    public Pack(long id, String name, String banner, Set<Song> song) {
        this.id = id;
        this.name = name;
        this.banner = banner;
        this.song = song;
    }

    @Override
    public String toString() {
        return String.format("Pack[id=%d, name='%s', count=%d, banner='%s']",
                id, name, banner);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBanner() {
        return banner;
    }

    public Set<Song> getSong() {
        return song;
    }
}

