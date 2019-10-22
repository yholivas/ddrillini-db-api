package club.ddrillini.api;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PackController {
	private static Pack[] packs;

	public PackController() {
		packs = new Pack[4];
		packs[0] = new Pack(1, "Mute Sims", 10);
		packs[1] = new Pack(2, "Notice Me Benpai", 12);
		packs[2] = new Pack(3, "Sudziosis", 16);
		packs[3] = new Pack(4, "Rikame's Simfiles", 13);
	}

	@RequestMapping(value = "/packs", method=RequestMethod.GET)
	public Pack[] getPacks() {
		return packs;
	}
}
