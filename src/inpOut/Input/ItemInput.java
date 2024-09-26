package inpOut.Input;

public class ItemInput {
    private final int size;
    private final Integer xA;
    private final Integer yA;
    private final Integer xB;
    private final Integer yB;


    public ItemInput(int size, Integer xA, Integer yA, Integer xB, Integer yB) {
        this.size = size;
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
    }

    public Integer getXA() {
        return xA;
    }

    public Integer getYA() {
        return yA;
    }

    public Integer getXB() {
        return xB;
    }

    public Integer getYB() {
        return yB;
    }

    public int getSize() {
        return size;
    }
}
