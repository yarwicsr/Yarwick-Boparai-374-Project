import java.util.*;

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

	public void ElevatorTime(List<Request> requests, Elevator elevator) {
		System.out.println("Starting Elevator...");
		System.out.println();
		List<Request> activeReq = new ArrayList<>();
		int i = 0;
		activeReq.add(requests.get(0));
		requests.remove(0);

		while (!activeReq.isEmpty()) {
			if (activeReq.get(0).floor > elevator.location) {
				elevator.direction = true;
			} else {
				elevator.direction = false;
			}
			if (activeReq.get(0).isPriority) {
				System.out.println("floor " + activeReq.get(0).floor + " has priority.  Going to that floor. ");
				elevator.location = activeReq.get(0).floor;
				activeReq.remove(activeReq.get(0));
				if (!requests.isEmpty()) {
					activeReq.add(requests.get(0));
					requests.remove(0);
				}
			}
			i = 0;
			while (!requests.isEmpty() && i < requests.size()) {
				Request r = requests.get(i++);
				if (elevator.direction) {
					if (r.floor < activeReq.get(0).floor && r.floor > elevator.location) {
						activeReq.add(r);
						requests.remove(r);
						i--;
					}
				} else if (!elevator.direction) {
					if (r.floor > activeReq.get(0).floor && r.floor < elevator.location) {
						activeReq.add(r);
						requests.remove(r);
						i--;
					}
				}
			}
			while (!activeReq.isEmpty()) {
				boolean flag = false;
				Request r = activeReq.get(0);
				int j = 0;
				for (j = 1; j < activeReq.size(); j++) {
					if (activeReq.get(j).floor == elevator.location) {
						flag = true;
						break;
					}
				}
				if (flag == true) {
					System.out.println("request for floor " + elevator.location + " has been completed");
					activeReq.remove(j);
				} else if (r.floor == elevator.location) {
					System.out.println("request for floor " + elevator.location + " has been completed");
					activeReq.remove(r);
				}
				if (elevator.direction) {
					elevator.location++;
				} else {
					elevator.location--;
				}
			}
			i = 0;
			while (!requests.isEmpty() && i < requests.size()) {
				Request r = requests.get(i++);
				if (elevator.direction) {
					if (r.floor > elevator.location) {
						activeReq.add(r);
						requests.remove(r);
						i--;
					} else {
						elevator.direction = !elevator.direction;
						activeReq.add(requests.get(0));
						requests.remove(0);
						i--;
					}
				} else {
					if (r.floor < elevator.location) {
						activeReq.add(r);
						requests.remove(r);
						i--;
					} else {
						System.out.println("Switching directions");
						elevator.direction = !elevator.direction;
						activeReq.add(requests.get(0));
						requests.remove(0);
						i--;
					}
				}
			}
		}
		System.out.println("Requests finished");
		System.out.println();
	}
}
