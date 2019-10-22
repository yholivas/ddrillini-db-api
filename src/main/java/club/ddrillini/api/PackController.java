package club.ddrillini.api;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class PackController {
    private static ArrayList<Pack> packs;

    public PackController() {
        packs = new ArrayList<>(4);
        packs.add(0, new Pack(1, "Mute Sims", 10));
        packs.add(1, new Pack(2, "Notice Me Benpai", 12));
        packs.add(2, new Pack(3, "Sudziosis", 16));
        packs.add(3, new Pack(4, "Rikame's Simfiles", 13));
    }

    @RequestMapping(value = "/packs", method = RequestMethod.GET)
    public Pack[] getPacks() {
        return packs.toArray(new Pack[packs.size()]);
    }

    @RequestMapping(value = "/packs/{id}", method = RequestMethod.GET)
    public Pack getPack(@PathVariable("id") long id) {
        return packs.get((int)(--id));
    }

    @RequestMapping(value = "/packs", method = RequestMethod.POST)
    public void createPack(@RequestBody Pack newPack) {
        packs.add(newPack);
    }
}
