package club.ddrillini.api;

public class Pack {
	private final long id;
	private final String name;
	private final int count;

	public Pack(long id, String name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
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

