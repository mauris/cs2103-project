package com.tasma;

import java.util.ArrayList;
import java.util.Scanner;

public class TasmaConsoleUI implements TasmaUserInterface {

	private Controller controller = new Controller();
	
	public void initialize() {
		controller.initialize();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Command: ");
			String input = sc.nextLine();
			controller.executeInput(input);
		}
	}
	
	@Override
	public void displayTasks(ArrayList<Task> tasks) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

	}

}
