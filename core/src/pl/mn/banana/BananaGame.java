package pl.mn.banana;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import pl.mn.banana.core.screen.CoreScreen;

public class BananaGame extends Game {

	private static final String TAG = "BananaGame";
	public static final boolean DEBUG_MODE = true;

	@Override
	public void create () {
		Gdx.app.log(TAG, "New game created!");
		setScreen(new CoreScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
