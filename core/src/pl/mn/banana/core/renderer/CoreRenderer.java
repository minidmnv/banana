package pl.mn.banana.core.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import pl.mn.banana.core.world.CoreWorld;

/**
 * @author mnicinski
 */
public class CoreRenderer {

	private CoreWorld world;
	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;

	public CoreRenderer(CoreWorld world, OrthographicCamera coreCamera) {
		this.world = world;

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(coreCamera.combined);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(coreCamera.combined);
	}

	public void render(float delta) {
		batcher.begin();
		world.getStage()
				.getActors()
				.forEach(actor -> actor.draw(batcher, 1));
		batcher.end();
	}
}
