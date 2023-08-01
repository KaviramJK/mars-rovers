package marsrovers;

import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;

public class Utilities {


    // Helper method to convert direction string to facing integer value (N=1, E=2, S=3, W=4)
    public static int getFacingValue(String direction){
        switch (direction) {
            case "N":
                return Rover.N;
            case "E":
                return Rover.E;
            case "S":
                return Rover.S;
            case "W":
                return Rover.W;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean isValidDirection(@NotNull String direction) {
       if(direction.equals("N")|| direction.equals("S") || direction.equals("W")|| direction.equals("E")){
           return true;
       }
       return false;
    }
}








