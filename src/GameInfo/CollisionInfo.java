package GameInfo;

import Game.GameEnvironment;
import Geometry.Line;
import Geometry.Point;
import Interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Collision info.
 */
public class CollisionInfo {
    private GameEnvironment gameEnvironment;
    private Line trajectory;

    // the point at which the collision occurs.

    /**
     * Collision point point.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return closeToStart(pointListOfIntersection());
    }


    /**
     * Collision object collidable.
     *
     * @return the collidable
     */
// the collidable object involved in the collision.
    public Collidable collisionObject() {
        if (collisionPoint() == null) return null;
        if (gameEnvironment.getCollidableList() == null) return null;
        for (Collidable collidable : gameEnvironment.getCollidableList()) {
            if (collidable.getCollisionRectangle().isPointOnRectangle(collisionPoint())) {
                return collidable;
            }
        }
        return null;

    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;

    }

    /**
     * Sets trajectory.
     *
     * @param trajectory the trajectory
     */
    public void setTrajectory(Line trajectory) {
        this.trajectory = trajectory;
    }

    private List<Point> pointListOfIntersection() {
        List<Point> pointList = new ArrayList<>();
        if (gameEnvironment.getCollidableList() == null) return null;
        for (Collidable collidable : this.gameEnvironment.getCollidableList()) {
            if (this.trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle()) != null) {
                pointList.add(this.trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle()));
            }
        }
        return pointList;
    }

    private Point closeToStart(List<Point> pointList) {
        if (pointList == null) return null;
        double distance = Integer.MAX_VALUE;
        Point pointOfCollison = null;
        for (Point point : pointList) {
            if (trajectory.getStart().distance(point) < distance) {
                distance = trajectory.getStart().distance(point);
                pointOfCollison = point;

            }
        }
        return pointOfCollison;
    }
}
