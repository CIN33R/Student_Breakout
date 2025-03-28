package org.bmhsla.breakout.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import org.bmhsla.breakout.ecs.components.*;

public class CollisionSystem extends EntitySystem {

    @Override
    public void update(float deltaTime) {

        for(Entity entity: getEngine().getEntitiesFor(Family.all(TypeTagComponent.class, PositionComponent.class, SizeComponent.class, DirectionComponent.class, SpeedComponent.class).get())) {

            TypeTagComponent typeTagComponent = entity.getComponent(TypeTagComponent.class);
            if(typeTagComponent.tag.equals("ball")) {
                PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
                SizeComponent sizeComponent = entity.getComponent(SizeComponent.class);
                DirectionComponent directionComponent = entity.getComponent(DirectionComponent.class);
                SpeedComponent speedComponent = entity.getComponent(SpeedComponent.class);

                // move ball
                positionComponent.position.x += directionComponent.direction.x * speedComponent.speed * deltaTime;
                positionComponent.position.y += directionComponent.direction.y * speedComponent.speed * deltaTime;

            }
        }

    }

}
