package asynchronous.futureExample.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExample {
	private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) {
		House house = new House(new DormRoom());
		house.toDoList().forEach( activitie -> threadPool.execute(() -> activitie.acomplished()));
		threadPool.shutdown();
	}
}

class House {
	private List<Room> rooms;
	
	House(Room... rooms){
		this.rooms = Arrays.asList(rooms);
	}
		
	List<Activitie> toDoList() {
		return this.rooms.stream().map(Room::toDoList)
				.reduce(new ArrayList<Activitie>(), (pivotate, activities) -> {
					pivotate.addAll(activities);
					return pivotate;
				});
	}
}

interface Activitie{
	void acomplished();
}

abstract class Room{
	abstract List<Activitie> toDoList();
}

class DormRoom extends Room {
	@Override
	List<Activitie> toDoList(){
		return Arrays.asList(
				this::doBed,
				this::swipeDormRoom,
				this::doWardrobe
				);	
	}

	private void doBed() { System.out.println("do your bed asd 3"); }
	
	private void swipeDormRoom() { System.out.println("Swipe dorm room 2"); }
	
	private void doWardrobe() { System.out.println("Do your wardrobe 1"); }
}
