public class Main {
    public enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main(String[] args) {
        Level level = getLevel(5);
        switchLevel(level);

        //Loop Through an Enum
        for(Level myVar:Level.values()){
            System.out.println(myVar);
        }
    }

    public static Level getLevel(int value) {
        if (value < 3) {
            return Level.LOW;
        } else if (value < 7) {
            return Level.MEDIUM;
        } else {
            return Level.HIGH;
        }
    }

    public static void switchLevel(Level level) {
        switch (level) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }
}



