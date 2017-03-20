package pl.mn.banana.core.object;

import java.util.Locale;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import pl.mn.banana.BananaGame;
import pl.mn.banana.util.Assets;

/**
 * @author mnicinski
 */
public class Player extends AbstractActor {

	private static final float SLOW_DOWN_MULTIPLIER = 5.5f;

	private Integer lives;
	private float speed = 8;
	private float accelerationAttribute = 5;
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
			Assets.instance.font.smallFont.draw(batch, String.format(Locale.getDefault(), "Rotation: %f, Velocity: x %f, y %f",
					getRotation(), velocity.x, velocity.y), 10, 45);
		}
	}

	@Override
	public void act(float delta) {
		speedUp();

		rotate();
		moveBy(velocity.x, velocity.y);

		slowDown(delta);
	}

	private void rotate() {
		float rotation = (((velocity.x * (-90) + velocity.y * 0) / velocity.x + velocity.y) + getRotation())
				/ (velocity.x + velocity.y);

		if (!(rotation != rotation)) {
			setRotation(rotation); // TODO: mnicinski (((x*degy + y*degy) / x+y) + currDeg) / x+y
		}
	}

	private void speedUp() {
		velocity.x += acceleration.x;
		velocity.x = velocity.x > speed ? speed : velocity.x;

		velocity.y += acceleration.y;
		velocity.y = velocity.y > speed ? speed : velocity.y;
	}

	private void slowDown(float delta) {
		acceleration = new Vector2(0,0);
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
		acceleration.x += x * accelerationAttribute;
		acceleration.y += y * accelerationAttribute;
	}
}
