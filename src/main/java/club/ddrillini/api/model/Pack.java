package club.ddrillini.api.model;

import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY , mappedBy="packId")
    private List<Song> songs;

    protected Pack() {}

    public Pack(long id, String name, String banner, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.banner = banner;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }
}

