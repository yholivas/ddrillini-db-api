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

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String subtitle;
    private String banner;
    private String artist;
    private long packId;

    protected Song() {}

    public Song(long id, String title, String subtitle, String banner,
            String artist, long pack) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.banner = banner;
        this.artist = artist;
        this.packId = pack;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBanner() {
        return banner;
    }

    public long getPackId() {
        return packId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getArtist() {
        return artist;
    }
}

