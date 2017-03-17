package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

/**
 * @author mnicinski
 */
public class Obstacle extends AbstractActor {

	private static final int OBSTACLE_MAX_VELOCITY = 150;
	private Random rand = new Random();
	private Vector2 velocity;

	public Obstacle(float x, float y) {
		super(new Texture("asteroid_0.png"));
		setX(x);
		setY(y);
		setWidth(look.getRegionWidth());
		setHeight(look.getRegionHeight());
		velocity = new Vector2(rand.nextFloat() * OBSTACLE_MAX_VELOCITY * getLurch(),
				rand.nextFloat() * OBSTACLE_MAX_VELOCITY * getLurch());
	}

	private int getLurch() {
		return rand.nextBoolean() ? 1 : -1;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(look, getX(), getY());
	}

	@Override
	public void act(float delta) {
		moveBy(velocity.x * delta, velocity.y * delta);
	}
}
