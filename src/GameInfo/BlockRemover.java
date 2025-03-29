package GameInfo;

import GameObject.Block;
import Geometry.Ball;
import Interfaces.HitListener;
import Game.GameLevel;


/**
 * The type Block remover.
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel     the game level
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {

        this.gameLevel.removeCollidable(beingHit);
        this.gameLevel.removeSprite(beingHit);
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        if (remainingBlocks.getValue() == 0) {
            gameLevel.setScore(100);
        }

    }
}

