package com.bromleyoil.rezelda;

import java.util.Arrays;

import com.bromleyoil.cog.model.Archetype;
import com.bromleyoil.cog.model.Box;
import com.bromleyoil.cog.model.Frame;
import com.bromleyoil.cog.model.State;
import com.bromleyoil.cog.persist.Handle;
import com.bromleyoil.cog.persist.YamlPersistor;

public class Main {

	public static void main(String[] args) {

		YamlPersistor yaml = new YamlPersistor();
		System.out.println(yaml.compose(Handle.of("Archetype.yml|player")));
		yaml.construct(Handle.of("Archetype.yml|player"), Archetype.class);

		// Archetype arch = getArch();
		// out.println((new Yaml()).dump(arch));
		// YamlPersistor yaml = new YamlPersistor();
		// out.println(yaml.present(arch));
	}

	public static Archetype getArch() {
		Frame frame;
		State state;

		Archetype arch = new Archetype();
		arch.setId("player");
		arch.setName("The Player");

		state = new State();
		state.setName("idle");
		frame = new Frame();
		frame.setDuration(1);
		state.getFrames().add(frame);
		arch.getStates().add(state);

		state = new State();
		state.setName("attack");
		frame = new Frame();
		frame.setDuration(21);
		frame.getBoxes().put("hit", Arrays.asList(new Box(2, 2, 28, 28)));
		state.getFrames().add(frame);
		frame = new Frame();
		frame.setDuration(22);
		state.getFrames().add(frame);
		frame = new Frame();
		frame.setDuration(23);
		state.getFrames().add(frame);
		arch.getStates().add(state);

		arch.getState(0).setNextState(arch.getState(1));

		return arch;
	}
}
