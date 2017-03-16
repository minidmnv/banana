package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author mnicinski
 */
public class Player extends Actor {

	private Integer lives;
	private float speed;
	private TextureRegion look = new TextureRegion(new Texture("player_ship_good.png"));

	public Player() {
		setX(85f);
		setY(635f);
		setWidth(look.getRegionWidth());
		setHeight(look.getRegionHeight());
		setRotation(-90f);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(look, getX(), getY(), getWidth() / 2, getHeight() / 2,
				getWidth(), getHeight(), 1, 1, getRotation());
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}
}
