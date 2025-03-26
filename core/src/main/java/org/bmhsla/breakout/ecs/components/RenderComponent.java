package org.bmhsla.breakout.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RenderComponent implements Component {

    public enum ShapeKind {
        RECTANGLE,
        CIRCLE,
        TRIANGLE
    }

    public ShapeKind shape = ShapeKind.RECTANGLE;
    public ShapeRenderer.ShapeType shapeType = ShapeRenderer.ShapeType.Filled;
    public Color color = Color.WHITE;


}
