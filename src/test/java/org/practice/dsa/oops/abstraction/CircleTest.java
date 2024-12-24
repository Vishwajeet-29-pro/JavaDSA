package org.practice.dsa.oops.abstraction;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.practice.dsa.oops.abstraction.shape.Circle;
import org.practice.dsa.oops.abstraction.shape.Shape;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testCalculateArea() throws NoSuchFieldException, IllegalAccessException {
        Shape circle = new Circle("Red",5);
        circle.calculateArea();

        Field areaField = Circle.class.getSuperclass().getDeclaredField("area");
        areaField.setAccessible(true);
        double area = (double) areaField.get(circle);

        assertEquals(78.54, area, 0.01);
    }

    @Disabled
    @Test
    public void testDisplayData() {
        Shape circle = new Circle("Red",5);
        circle.calculateArea();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        circle.displayDetails();

        // Verify the output
        String expectedOutput = "The color for shape is : Red\n" +
                "The area of the shape is: 78.54\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
