package org.bmhsla.breakout.ecs.factories;

import com.badlogic.ashley.core.Entity;
import org.bmhsla.breakout.ecs.components.*;

public class EntityFactory {

    public Entity createPaddleEntity() {
        Entity paddle = new Entity();

        TypeTagComponent typeTag = new TypeTagComponent();
        typeTag.tag = "paddle";
        paddle.add(typeTag);

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.position.x = 10;
        positionComponent.position.y = 10;
        paddle.add(positionComponent);

        SizeComponent sizeComponent = new SizeComponent();
        sizeComponent.size.x = 100;
        sizeComponent.size.y = 20;
        paddle.add(sizeComponent);

        SpeedComponent speedComponent = new SpeedComponent();
        speedComponent.speed = 200;
        paddle.add(speedComponent);

        paddle.add(new RenderComponent());

        return paddle;
    }

}
