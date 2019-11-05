package club.ddrillini.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String banner;

    @Transient
    public Long songCount;

    protected Pack() {}

    public Pack(long id, String name, String banner) {
        this.id = id;
        this.name = name;
        this.banner = banner;
    }

    @Override
    public String toString() {
        return String.format("Pack[id=%d, name='%s', count=%d, banner='%s']",
                id, name, songCount, banner);
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
}

