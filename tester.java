import java.util.ArrayList;
import java.util.List;

class Tester {
	public static void main(String[] args) {
		// elevator location
		int location = 10;
		// direction of elevator true = up false = down
		boolean direction = true;
		List<Request> requests = new ArrayList<>();

    // continue to make and add requests in this format
		Request Bob = new Request(2, false);
		requests.add(Bob);
		
		Elevator elevator = new Elevator(location, direction);
		System.out.println("Elevator location: " + location + " | Elevator direction up/down (true/false): " + direction);

		long start = System.currentTimeMillis();
		elevator.ElevatorTime(requests, elevator);
		long end = (System.currentTimeMillis() - start);
		System.out.println("Completed in " + end + " ms");

	}
}
