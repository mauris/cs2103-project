package com.tasma.commands;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tasma.MockStorage;
import com.tasma.TaskCollection;
import com.tasma.MockUserInterface;

public class CommandFactoryTest {

	private CommandFactory factory;
	private MockUserInterface userInterface;
	private MockStorage storage;
	private TaskCollection collection;
	
	@Before
	public void setUp() throws Exception {
		userInterface = new MockUserInterface();
		storage = new MockStorage();
		collection = new TaskCollection(storage);
		factory = new CommandFactory(userInterface, collection);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCommand1() {
		CommandInterface command = factory.getCommand("add test");
		assertThat(command, instanceOf(AddCommand.class));
	}

	@Test
	public void testGetCommand2() {
		CommandInterface command = factory.getCommand("list");
		assertThat(command, instanceOf(ListCommand.class));
	}

	@Test
	public void testGetCommand3() {
		CommandInterface command = factory.getCommand("search test");
		assertThat(command, instanceOf(SearchCommand.class));
	}

	@Test
	public void testGetCommand4() {
		CommandInterface command = factory.getCommand("list");
		assertThat(command, instanceOf(ListCommand.class));
	}

}