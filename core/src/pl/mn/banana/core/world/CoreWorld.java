package pl.mn.banana.core.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

import pl.mn.banana.core.object.Player;

/**
 * @author mnicinski
 */
public class CoreWorld {

	private Stage stage;
	private Player player;
	private List enemies;
	private List obstacles;
	private List food;

	public CoreWorld(OrthographicCamera coreCamera) {
		enemies = new ArrayList();
		obstacles = new ArrayList();
		food = new ArrayList();
		player = new Player();
	}

	public Stage getStage() {
		return stage;
	}

	public void update(float delta) {

	}
}
