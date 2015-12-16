package week03.ToDoList;

public class Task implements Comparable<Task>{

	protected int priority;
	protected double time;
	protected boolean finish; 
		
	public Task(double time) {
		this.priority = 5;
		this.time = time;
		finish = false;
	}
	
	public Task(double time, int priority) {
		this.priority = priority;
		this.time = time;
		finish = false;
	}


	public int compareTo(Task t) {
		if (priority < t.priority) {
			return  1;
		} else if (priority == t.priority) {
			if (time < t.time) {
				return 1;
			} else if (time == t.time) {
				return 0;
			} else {return -1;}
		}
		return -1;
	}
		

	public double getTime() {
		return time;
	}
	
	public void taskDone(){
		finish = true;
	}
	
	public boolean isFinishsed() {
		return finish;
	}
}
