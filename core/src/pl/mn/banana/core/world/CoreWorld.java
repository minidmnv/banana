package pl.mn.banana.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

import pl.mn.banana.core.object.Enemy;
import pl.mn.banana.core.object.Food;
import pl.mn.banana.core.object.Obstacle;
import pl.mn.banana.core.object.Player;

/**
 * @author mnicinski
 */
public class CoreWorld {

	private static final Long FOOD_GENERATE_LIMIT = 5L;
	private static final Long OBSTACLE_GENERATE_LIMIT = 8L;
	private static final Long ENEMY_GENERATE_LIMIT = 2L;
	private Stage stage;
	private Player player;

	private List<Enemy> enemies = new ArrayList();
	private List<Obstacle> obstacles = new ArrayList();
	private List<Food> food = new ArrayList();

	public CoreWorld(OrthographicCamera coreCamera) {
		initObjects();
		initStage();
	}

	private void initObjects() {
		generateEnemies();
		generateObstacles();
		generateFood();
		player = new Player();
	}

	private void initStage() {
		stage = new Stage();

		enemies.forEach(stage::addActor);
		obstacles.forEach(stage::addActor);
		food.forEach(stage::addActor);
		stage.addActor(player);
	}

	private void generateFood() {
		IntStream.iterate(0, i -> i+ 1)
				.limit(FOOD_GENERATE_LIMIT)
				.forEach(i -> food.add(new Food()));
	}

	private void generateObstacles() {
		IntStream.iterate(0, i -> i+ 1)
				.limit(OBSTACLE_GENERATE_LIMIT)
				.forEach(i -> obstacles.add(new Obstacle()));
	}

	private void generateEnemies() {
		IntStream.iterate(0, i -> i+ 1)
				.limit(ENEMY_GENERATE_LIMIT)
				.forEach(i -> enemies.add(new Enemy()));
	}

	public Stage getStage() {
		return stage;
	}

	public void update(float delta) {
		player.act(delta);
	}

}
