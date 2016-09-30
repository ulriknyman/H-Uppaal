package SW9.model_canvas.arrow_heads;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class SimpleArrowHead extends ArrowHead {

    private static final double TRIANGLE_LENGTH = 20d;
    private static final double TRIANGLE_WIDTH = 15d;

    public SimpleArrowHead() {
        super();

        addChild(initializeTriangle());
    }

    private Path initializeTriangle() {
        final Path simpleArrow = new Path();

        MoveTo start = new MoveTo();
        LineTo l1 = new LineTo();
        MoveTo l2 = new MoveTo();
        LineTo l3 = new LineTo();

        start.xProperty().bind(xProperty);
        start.yProperty().bind(yProperty);

        l1.xProperty().bind(start.xProperty().subtract(TRIANGLE_WIDTH / 2));
        l1.yProperty().bind(start.yProperty().subtract(TRIANGLE_LENGTH));

        l2.xProperty().bind(start.xProperty().add(TRIANGLE_WIDTH / 2));
        l2.yProperty().bind(start.yProperty().subtract(TRIANGLE_LENGTH));

        l3.xProperty().bind(start.xProperty());
        l3.yProperty().bind(start.yProperty());

        simpleArrow.setStroke(Color.BLACK);
        simpleArrow.getElements().addAll(start, l1, l2, l3);

        return simpleArrow;
    }

    @Override
    public double getHeadHeight() {
        return TRIANGLE_LENGTH;
    }

    @Override
    public double getHeadWidth() {
        return TRIANGLE_WIDTH;
    }

    @Override
    public boolean shouldBindToTip() {
        return true;
    }

}