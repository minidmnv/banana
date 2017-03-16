package pl.mn.banana.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import pl.mn.banana.core.renderer.CoreRenderer;
import pl.mn.banana.core.world.CoreWorld;

/**
 * @author mnicinski
 */
public class CoreScreen extends ScreenAdapter implements GestureListener {

	private CoreWorld world;
	private CoreRenderer renderer;
	private OrthographicCamera coreCamera;

	public CoreScreen() {
		coreCamera = new OrthographicCamera();
		coreCamera.setToOrtho(true, 1280, 800);

		world = new CoreWorld(coreCamera);
		Gdx.input.setInputProcessor(world.getStage());
		renderer = new CoreRenderer(world, coreCamera);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}
