package pl.mn.banana.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

import pl.mn.banana.core.object.*;

import static pl.mn.banana.core.screen.CoreScreen.VIEWPORT_HEIGHT;
import static pl.mn.banana.core.screen.CoreScreen.VIEWPORT_WIDTH;

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
	private Random random = new Random();

	public CoreWorld(OrthographicCamera coreCamera) {
		init();
	}

	private void init() {
		stage = new Stage();
		generateEnemies();
		generateObstacles(OBSTACLE_GENERATE_LIMIT);
		generateFood();
		stage.addActor(generatePlayer());
	}

	private Player generatePlayer() {
		player = new Player();
		return player;
	}

	private void generateFood() {
		IntStream.iterate(0, i -> i+ 1)
				.limit(FOOD_GENERATE_LIMIT)
				.forEach(i -> food.add(new Food()));
		food.forEach(stage::addActor);
	}

	private void generateObstacles(Long count) {
		IntStream.iterate(0, i -> i+ 1)
				.limit(count)
				.forEach(i -> obstacles.add(
						new Obstacle(random.nextFloat() * VIEWPORT_WIDTH, random.nextFloat() * VIEWPORT_HEIGHT)));
		obstacles.forEach(stage::addActor);
	}

	private void generateEnemies() {
		IntStream.iterate(0, i -> i+ 1)
				.limit(ENEMY_GENERATE_LIMIT)
				.forEach(i -> enemies.add(new Enemy()));
		enemies.forEach(stage::addActor);
	}

	public Stage getStage() {
		return stage;
	}

	public void update(float delta) {
		stage.getActors()
				.forEach(actor -> actor.act(delta));


		refillObstacles();
	}

	private void refillObstacles() {
		List<Obstacle> obstaclesToRemove = obstacles.parallelStream()
				.filter(this::isObstacleVisible)
				.collect(Collectors.toList());
		Long size = (long) obstaclesToRemove.size();
		obstaclesToRemove
				.forEach(obstacles::remove);
		generateObstacles(size);
	}

	private boolean isObstacleVisible(Obstacle obstacle) {
		return obstacle.getX() - obstacle.getWidth() > VIEWPORT_WIDTH ||
				obstacle.getX() + obstacle.getWidth() < 0 ||
				obstacle.getY() + obstacle.getHeight() < 0 ||
				obstacle.getY() - obstacle.getHeight() > VIEWPORT_HEIGHT;
	}

}
