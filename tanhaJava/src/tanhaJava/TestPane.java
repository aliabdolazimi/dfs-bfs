
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanhaJava;

/**
 *
 * @author Radvin
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



    public class TestPane extends JPanel {

        private Ellipse2D circle1;
        private Ellipse2D circle2;

        private Point2D drawTo;

        public TestPane(int x1,int y1,int x2,int y2,int r) {
            circle1 = new Ellipse2D.Double(x1, y1, r, r);
            circle2 = new Ellipse2D.Double(x2,y2, r, r);
        }

        protected Point2D center(Rectangle2D bounds) {
            return new Point2D.Double(bounds.getCenterX(), bounds.getCenterY());
        }

        protected double angleBetween(Shape from, Shape to) {
            return angleBetween(center(from.getBounds2D()), center(to.getBounds2D()));
        }

        protected double angleBetween(Point2D from, Point2D to) {
            double x = from.getX();
            double y = from.getY();

            // This is the difference between the anchor point
            // and the mouse.  Its important that this is done
            // within the local coordinate space of the component,
            // this means either the MouseMotionListener needs to
            // be registered to the component itself (preferably)
            // or the mouse coordinates need to be converted into
            // local coordinate space
            double deltaX = to.getX() - x;
            double deltaY = to.getY() - y;

            // Calculate the angle...
            // This is our "0" or start angle..
            double rotation = -Math.atan2(deltaX, deltaY);
            rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

            return rotation;
        }

        protected Point2D getPointOnCircle(Shape shape, double radians) {
            Rectangle2D bounds = shape.getBounds();
//          Point2D point = new Point2D.Double(bounds.getX(), bounds.getY());
            Point2D point = center(bounds);
            return getPointOnCircle(point, radians, Math.max(bounds.getWidth(), bounds.getHeight()) / 2d);
        }

        protected Point2D getPointOnCircle(Point2D center, double radians, double radius) {

            double x = center.getX();
            double y = center.getY();

            radians = radians - Math.toRadians(90.0); // 0 becomes th?e top
            // Calculate the outter point of the line
            double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
            double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

            return new Point2D.Double(xPosy, yPosy);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
        public Line2D getLine(){
            double from = angleBetween(circle1, circle2);
            double to = angleBetween(circle2, circle1);
            Point2D pointFrom = getPointOnCircle(circle1, from);
            Point2D pointTo = getPointOnCircle(circle2, to);

            Line2D line = new Line2D.Double(pointFrom, pointTo);
            return line;
        }
    }

