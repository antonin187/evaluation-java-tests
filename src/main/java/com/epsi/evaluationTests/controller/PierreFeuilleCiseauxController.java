package com.epsi.evaluationTests.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.action.Action;

@RestController
@RequestMapping("/game")
public class PierreFeuilleCiseauxController {
	
	public static int randomChoice() {
		return (int) Math.random() * (3 - 1);
	}
	
	@GetMapping("/play/{action}")
	public String sayHello(@PathVariable("actiion") String action) {
		
		
		ArrayList<String> possibilities = new ArrayList<String>();
		
		possibilities.add("ciseaux");
		possibilities.add("pierre");
		possibilities.add("feuille");
		
		String ordiResponse = possibilities.get(randomChoice());
		
		
		
		
		switch (action) {
		
			case "pierre":
				switch (ordiResponse) {
				case "pierre":
					return "Vous avez joué pierre, l'ordinateur à joué pierre, vous avez fait égalité.";
				
					
				case "feuille":
					return "Vous avez joué pierre, l'ordinateur à joué feuille, vous avez perdu.";
				
					
				case "ciseaux":
					return "Vous avez joué pierre, l'ordinateur à joué ciseaux, vous avez gagné.";
				

				default:
					break;
				}
				
				
				
				
			case "ciseaux":
				switch (ordiResponse) {
				case "pierre":
					return "Vous avez joué ciseaux, l'ordinateur à joué pierre, vous avez perdu.";
				
					
				case "feuille":
					return "Vous avez joué ciseaux, l'ordinateur à joué feuille, vous avez gagné.";
				
					
				case "ciseaux":
					return "Vous avez joué ciseaux, l'ordinateur à joué ciseaux, vous avez fait égalité.";
				

				default:
					break;
				}
		
				
			case "feuille":
				switch (ordiResponse) {
				case "pierre":
					return "Vous avez joué feuille, l'ordinateur à joué pierre, vous avez gagné.";
				
					
				case "feuille":
					return "Vous avez joué feuille, l'ordinateur à joué feuille, vous avez fait égalité.";
				
					
				case "ciseaux":
					return "Vous avez joué feuille, l'ordinateur à joué ciseaux, vous avez perdu.";
				

				default:
					break;
				}
				
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
		// return "Hello " + name ;
	}
	
	//@GetMapping("/restart")
	//public void scoreToZero
	
}
