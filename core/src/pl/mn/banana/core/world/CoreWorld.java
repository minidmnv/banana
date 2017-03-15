package pl.mn.banana.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
		enemies = generateEnemies();
		obstacles = generateObstacles();
		food = generateFood();
		player = new Player();
	}

	private ArrayList generateFood() {
		IntStream.empty();
		return new ArrayList();
	}

	private ArrayList generateObstacles() {
		return new ArrayList();
	}

	private ArrayList generateEnemies() {
		return new ArrayList();
	}

	public Stage getStage() {
		return stage;
	}

	public void update(float delta) {

	}
}
