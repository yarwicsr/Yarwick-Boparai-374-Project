import java.util.*;
//add time element into method!

public class Elevator {
	int location;
	boolean direction;

	public Elevator(int location, boolean direction) {
		this.location = location;
		this.direction = direction;
	}

	public int getLocation() {
		return this.location;
	}

	public boolean getDirection() {
		return this.direction;
	}

	public int ElevatorTime(List<Request> requests, Elevator elevator) {
		List<Request> activeReq = new ArrayList<>();
		activeReq.add(requests.get(0));
		requests.remove(0);
		int time = 0;
		while (!activeReq.isEmpty()) {
			// set elevator direction based off of first request
			if (activeReq.get(0).floor > elevator.location) {
				elevator.direction = true;
			} else {
				elevator.direction = false;
			}
			if (activeReq.get(0).isPriority) {
				elevator.location = activeReq.get(0).floor;
				time += 5;
			} else {
				for (Request r : requests) {
					if (elevator.direction) {
						if (r.floor < activeReq.get(0).floor && r.floor > elevator.location) {
							activeReq.add(r);
							requests.remove(r);
							time += 5;
						}
					} else if (!elevator.direction) {
						if (r.floor > activeReq.get(0).floor && r.floor < elevator.location) {
							activeReq.add(r);
							requests.remove(r);
							time += 5;
						}
					}
				}
				while (elevator.location != activeReq.get(0).floor) {
					for (Request r : activeReq) {
						if (elevator.direction) {
							if (r.floor == elevator.location + 1) {
								elevator.location++;
								activeReq.remove(r);
								time += 5;
							}
						} else {
							if (r.floor == elevator.location - 1) {
								elevator.location--;
								activeReq.remove(r);
								time += 5;
							}
						}
					}
				}
				for (Request r : requests) {
					if (elevator.direction) {
						if (r.floor > elevator.location) {
							activeReq.add(r);
						} else {
							elevator.direction = !elevator.direction;
							activeReq.add(requests.get(0));
						}
					} else {
						if (r.floor < elevator.location) {
							activeReq.add(r);
						} else {
							elevator.direction = !elevator.direction;
							activeReq.add(requests.get(0));
						}
					}
				}
			}
		}

		System.out.println("Requests finished");
		return time;
	}
}