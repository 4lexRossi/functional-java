package asynchronous.futureExample.example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExample2 {
	private static final ExecutorService peopleToExecute = Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) throws InterruptedException {
		House house = new House(new DormRoom());
		List<Future<String>> futuros = 
		new CopyOnWriteArrayList<>(house.toDoList().stream()
				.map( activitie -> peopleToExecute.submit(() -> {
						try {
							return activitie.acomplished();						
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
						return null;				
					})
				)
				.collect(Collectors.toList()));
		
		while(true) {
			int unacomplishedToDoList = 0;
			for (Future<?> futuro : futuros) {
				if(futuro.isDone()) {
					try {
						System.out.println("Congratz u done "+ futuro.get());
						futuros.remove(futuro);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {						
						e.printStackTrace();
					}
				}
				else {
					unacomplishedToDoList++;
				}
			}
			if (futuros.stream().allMatch(Future::isDone)){
				break;
			}
			System.out.println("Number of activities undone "+ unacomplishedToDoList);
			Thread.sleep(500);
		}
		peopleToExecute.shutdown();
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
	String acomplished() throws InterruptedException;;
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

	private String doBed() throws InterruptedException { 
		Thread.sleep(3000);
		String doBed = "do your bed";
		System.out.println(doBed);
		return	doBed;
		}
	
	private String swipeDormRoom() throws InterruptedException {
		Thread.sleep(5000);
		String swipeDormRoom = "swipe dorm room";
		System.out.println(swipeDormRoom);
		return swipeDormRoom;
		}
	
	private String doWardrobe() throws InterruptedException {		
		Thread.sleep(7000);
		String doWardrobe = "Do your wardrobe";
		System.out.println(doWardrobe); 
		return doWardrobe;
		}
}
