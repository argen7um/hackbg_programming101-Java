package week03.ToDoList;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class ToDoList {

	private PriorityQueue<Task> tasks;
	private ArrayList<Task> doneTasks;
	double timeLeft;
	double timeInit;
	
	public ToDoList(double timeInit) {
		tasks = new PriorityQueue<>();
		doneTasks = new ArrayList<>();
		this.timeLeft = timeInit;
		this.timeInit = timeInit;
	}

	public void addTask(Task t) {
		tasks.add(t);
	}

	public boolean canFinish() {
		Task temp;
		while (timeLeft > 0 && !tasks.isEmpty()) {
			temp = tasks.peek();
			if (temp.getTime() <= timeLeft) {
				markFinished(temp);
				tasks.poll();
			}
			timeLeft -= temp.getTime();
		}
		if (tasks.isEmpty()) {
			return true;
		}
		return false;
	}

	public void markFinished(Task t) {
		t.taskDone();
		doneTasks.add(t);
	}

	public Task getTop() {
		if (!doneTasks.isEmpty()) {
			return doneTasks.get(0);
		}
		return null;
	}
	
	public double getRemainigTime() {
		return timeLeft;	
	}
	
	public double getTimeNeeded() {
		return timeInit - timeLeft;
		
	}
	
	public static void main(String [] args) {
		ToDoList todo = new ToDoList(11); //11 hours remaining!
		todo.addTask(new StudyForAlgebraTask(3, 2));// time = 3,  priority = 2
		todo.addTask(new LearnGeometryTask(5)); 
		todo.addTask(new GoOutTask(1.5f, 7));

		if (todo.canFinish()){
		    System.out.println("Woohoo!");
		} else {
		    System.out.println("I am ...screwed :(");
		}

		System.out.println(todo.getTop()); //StudyForAlgebraTask
		System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list
	}
}
