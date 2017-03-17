package pl.mn.banana.core.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author minidmnv
 */
public abstract class AbstractActor extends Actor {

    protected final TextureRegion look;

    protected AbstractActor(Texture look) {
        this.look = new TextureRegion(look);
    }
}
