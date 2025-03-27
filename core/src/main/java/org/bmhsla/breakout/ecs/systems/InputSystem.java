package org.bmhsla.breakout.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.bmhsla.breakout.ecs.components.PositionComponent;
import org.bmhsla.breakout.ecs.components.SpeedComponent;
import org.bmhsla.breakout.ecs.components.TypeTagComponent;

public class InputSystem extends EntitySystem {
    @Override
    public void update(float deltaTime) {
        for(Entity entity: getEngine().getEntitiesFor(Family.all(TypeTagComponent.class, PositionComponent.class, SpeedComponent.class).get())) {
            TypeTagComponent typeTagComponent = entity.getComponent(TypeTagComponent.class);

            if(!typeTagComponent.tag.equals("paddle")) {
                continue;
            }

            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            SpeedComponent speedComponent = entity.getComponent(SpeedComponent.class);

            if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                positionComponent.position.x -= speedComponent.speed * deltaTime;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                positionComponent.position.x += speedComponent.speed * deltaTime;
            }
        }
    }
}
