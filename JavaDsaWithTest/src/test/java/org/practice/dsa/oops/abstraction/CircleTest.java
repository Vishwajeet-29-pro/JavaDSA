package org.practice.dsa.oops.abstraction;

import org.junit.jupiter.api.Test;
import org.practice.dsa.oops.abstraction.shape.Circle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CircleTest {

    @Test
    public void testCircleDraw() {
        // create mock object of drawable
        Circle circle = mock(Circle.class);
        //call the draw method.
        circle.draw();
        // Verify that the draw method is called.
        verify(circle).draw();
    }
}
