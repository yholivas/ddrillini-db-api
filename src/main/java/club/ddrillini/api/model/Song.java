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
    private String banner;
    private long packId;

    protected Song() {}

    public Song(long id, String title, String banner, long pack) {
        this.id = id;
        this.title = title;
        this.banner = banner;
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
}

