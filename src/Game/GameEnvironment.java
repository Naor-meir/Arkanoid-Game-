package Game;

import GameInfo.CollisionInfo;
import Geometry.Line;
import Interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 */
public class GameEnvironment {
    private List<Collidable> collidableList = new ArrayList<>();

    /**
     * Add collidable.
     *
     * @param c the c
     */
// add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
// Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo collisionInfo = new CollisionInfo();
        collisionInfo.setTrajectory(trajectory);
        collisionInfo.setGameEnvironment(this);
        if (collisionInfo.collisionPoint() == null || collisionInfo.collisionObject() == null)
            return null;
        return collisionInfo;

    }

    /**
     * Gets collidable list.
     *
     * @return the collidable list
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }
}