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

