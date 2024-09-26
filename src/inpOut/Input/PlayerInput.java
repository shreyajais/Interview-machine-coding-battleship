package inpOut.Input;

public class PlayerInput {
    private final Integer targetX;
    private final Integer targetY;
    private final Integer playerNum;

    public PlayerInput(Integer playerNum, Integer targetX, Integer targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.playerNum = playerNum;
    }

    public Integer getPlayerNum() {
        return playerNum;
    }

    public Integer getTargetX() {
        return targetX;
    }

    public Integer getTargetY() {
        return targetY;
    }
}
