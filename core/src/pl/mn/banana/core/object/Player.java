package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * @author mnicinski
 */
public class Player extends AbstractActor {

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
	}

	@Override
	public void act(float delta) {
		velocity.x += acceleration.x;
		moveBy(velocity.x, velocity.y);
		acceleration.x += acceleration.x > 0 ? -delta : delta;
		acceleration.y += acceleration.y > 0 ? -delta : delta;
	}

	public void speedUp(int x, int y) {
		acceleration.x += x;
		acceleration.y += y;
	}
}
