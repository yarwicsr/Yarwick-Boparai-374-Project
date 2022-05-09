public class Request {
	public int floor;
	public boolean isPriority;

	public Request(int floor, boolean isPriority) {
		this.floor = floor;
		this.isPriority = isPriority;
	}

	public Request() {
		this.floor = 1;
		this.isPriority = false;
	}
}
