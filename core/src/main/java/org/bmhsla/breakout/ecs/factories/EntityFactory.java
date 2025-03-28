package org.bmhsla.breakout.ecs.factories;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import org.bmhsla.breakout.ecs.components.*;

public class EntityFactory {

    public Entity createPaddleEntity() {
        Entity paddle = new Entity();

        TypeTagComponent typeTag = new TypeTagComponent();
        typeTag.tag = "paddle";
        paddle.add(typeTag);

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.position.x = MathUtils.random(0, Gdx.graphics.getWidth());
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

    public Entity createBallEntity() {
        Entity ball = new Entity();

        TypeTagComponent typeTag = new TypeTagComponent();
        typeTag.tag = "ball";
        ball.add(typeTag);

        PositionComponent positionComponent = new PositionComponent();
        positionComponent.position.x = MathUtils.random(0, Gdx.graphics.getWidth());
        positionComponent.position.y = MathUtils.random(Gdx.graphics.getHeight() / 2f, Gdx.graphics.getHeight());
        ball.add(positionComponent);

        SizeComponent sizeComponent = new SizeComponent();
        sizeComponent.size.x = 10;
        sizeComponent.size.y = 10;
        ball.add(sizeComponent);

        SpeedComponent speedComponent = new SpeedComponent();
        speedComponent.speed = 500;
        ball.add(speedComponent);

        DirectionComponent directionComponent = new DirectionComponent();
        directionComponent.direction.x = MathUtils.random(-1f, 1f);
        directionComponent.direction.y = MathUtils.random(-1f, 1f);
        ball.add(directionComponent);

        RenderComponent renderComponent = new RenderComponent();
        renderComponent.shape = RenderComponent.ShapeKind.CIRCLE;
        ball.add(renderComponent);

        return ball;
    }

}
