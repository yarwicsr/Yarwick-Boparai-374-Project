import java.util.ArrayList;
import java.util.List;

class Tester {
	public static void main(String[] args) {
		// elevator location
		int location = 1;
		// direction of elevator
		// true = up
		// false = down
		boolean direction = true;
		List<Request> people = new ArrayList<>();
		Request Bob = new Request(2, false);
		people.add(Bob);

		Elevator elevator = new Elevator(location, direction);
		int time = elevator.ElevatorTime(people, elevator);
		System.out.println(time);
	}
}