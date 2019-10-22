package club.ddrillini.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // no annotation means the properties are mapped to columns with the same name in table
    private String name;
    private int count;

    protected Pack() {}

    public Pack(long id, String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Pack[id=%d, name='%s', count=%d]", id, name, count);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}

