package club.ddrillini.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
    private String banner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id")
    private Pack pack;

    protected Song() {}

    public Song(long id, String title, String banner, Pack pack) {
        this.id = id;
        this.title = title;
        this.banner = banner;
        this.pack = pack;
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

    public Pack getPack() {
        return pack;
    }
}

