package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import pl.mn.banana.BananaGame;
import pl.mn.banana.util.Assets;

/**
 * @author mnicinski
 */
public class Player extends AbstractActor {

	private static final float SLOW_DOWN_MULTIPLIER = 5.5f;

	private Integer lives;
	private float speed;
	private Vector2 velocity = new Vector2(0,0);
	private Vector2 acceleration = new Vector2(0, 0);

	public Player() {
		super(new Texture("player_ship_good.png"));
		setX(85f);
		setY(635f);
		setWidth(look.getRegionWidth());
		setHeight(look.getRegionHeight());
		setRotation(-90f);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(look, getX(), getY(), getWidth() / 2, getHeight() / 2,
				getWidth(), getHeight(), 1, 1, getRotation());
		if (BananaGame.DEBUG_MODE) {
			Assets.instance.font.smallFont.draw(batch, String.format("Acceleration: x %f, y %f, Velocity: x %f, y %f",
					acceleration.x, acceleration.y, velocity.x, velocity.y), 10, 85);
		}
	}

	@Override
	public void act(float delta) {
		velocity.x += acceleration.x;
		moveBy(velocity.x, velocity.y);
		acceleration = new Vector2(0,0);
		slowDown(delta);
	}

	private void slowDown(float delta) {
		float slowDownSpeed = SLOW_DOWN_MULTIPLIER * delta;

		if (velocity.x > 0) {
			velocity.x = velocity.x > slowDownSpeed ? velocity.x - slowDownSpeed : 0;
		} else if (velocity.x < 0) {
			velocity.x = velocity.x < -slowDownSpeed ? velocity.x + slowDownSpeed : 0;
		}

		if (velocity.y > 0) {
			velocity.y = velocity.y > slowDownSpeed ? velocity.y - slowDownSpeed : 0;
		} else if (velocity.x < 0) {
			velocity.y = velocity.y < -slowDownSpeed ? velocity.y + slowDownSpeed : 0;
		}
	}

	public void speedUp(int x, int y) {
		acceleration.x += x;
		acceleration.y += y;
	}
}
