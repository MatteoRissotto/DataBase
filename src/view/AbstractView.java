package view;

import java.util.Scanner;
import controller.Request;

public class AbstractView {
	
	private Scanner scanner;

	/**
	*Questo metodo è usato da tutti i controller che lo ereditano (non devono definirlo) estendendo questa classe
	*/
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public int getInt() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	public void showOptions() {
		// TODO Auto-generated method stub
		
	}

	public void submit() {
		// TODO Auto-generated method stub
		
	}

}
