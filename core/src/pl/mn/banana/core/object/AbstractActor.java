package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static pl.mn.banana.BananaGame.DEBUG_MODE;

/**
 * @author minidmnv
 */
public abstract class AbstractActor extends Actor {

    protected final TextureRegion look;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();

    protected AbstractActor(Texture look) {
        this.look = new TextureRegion(look);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (DEBUG_MODE) {
            batch.end();
            drawDebug(batch.getProjectionMatrix());
            batch.begin();
        }
    }

    private void drawDebug(Matrix4 projectionMatrix) {
        shapeRenderer.setProjectionMatrix(projectionMatrix);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        drawDebugShape();
        shapeRenderer.end();
    }

    protected void drawDebugShape() {
        shapeRenderer.rect(getX(), getY(), getWidth() / 2, getHeight() / 2, getWidth(), getHeight(), 1, 1, getRotation());
    }
}
