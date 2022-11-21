package Defaults;

public enum Positions {
    TOPLEFT,
    TOPRIGHT,
    LOWLEFT,
    LOWRIGHT;

    public static Positions random(){
        int randomPosition = (int) (Math.random() * 4);
        switch (randomPosition){
            case 0 -> {
                return TOPLEFT;
            }
            case 1 -> {
                return TOPRIGHT;
            }
            case 2 -> {
                return LOWLEFT;
            }
            case 3 -> {
                return LOWRIGHT;
            }
        }
        return null;
    }
}
