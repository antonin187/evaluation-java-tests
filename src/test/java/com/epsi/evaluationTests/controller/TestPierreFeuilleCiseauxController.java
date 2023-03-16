package com.epsi.evaluationTests.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PierreFeuilleCiseauxController.class)
public class TestPierreFeuilleCiseauxController {
	
	ArrayList<String> possibilities = new ArrayList<String>();
	String pierre = "pierre";
	String feuille = "feuille";
	String ciseaux = "ciseaux";
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeAll
	public void init_game() {
		possibilities.add(pierre);
		possibilities.add(feuille);
		possibilities.add(ciseaux);
		
	}
	
	@Test
	public void test_play_action_endpoint() throws Exception {
		
		MvcResult result = mockMvc.perform( get("/game/play/" + pierre))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		
		when(PierreFeuilleCiseauxController.randomChoice()).thenReturn(1);
		
		
		
		assertEquals("Vous avez joué pierre, l'ordinateur à joué ciseaux, vous avez gagné.", content);
		
		
	}
	
	@Test
	public void set_scroe_to_zero() throws Exception {
		
		MvcResult result = mockMvc.perform( get("/game/restart/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		assertEquals(0, content);
		
		
	}
	
	@Test
	public void get_score() throws Exception {
		
		MvcResult result = mockMvc.perform( get("/game/score/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		assertEquals(0, content);
		
		
	}

}
