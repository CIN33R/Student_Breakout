package org.bmhsla.breakout;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.bmhsla.breakout.ecs.factories.EntityFactory;
import org.bmhsla.breakout.ecs.systems.RenderSystem;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameHandler extends ApplicationAdapter {
    private Engine engine;

    @Override
    public void create() {
        engine = new Engine();

        engine.addSystem(new RenderSystem());

        EntityFactory entityFactory = new EntityFactory();
        engine.addEntity(entityFactory.createPaddleEntity());
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        engine.update(Gdx.graphics.getDeltaTime());
    }

}
