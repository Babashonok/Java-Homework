import tat.bsu.route.ObsessionExceptionHandler;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;
import tat.bsu.transport.*;
import java.io.*;
import java.util.Scanner;

/**
 * Program emulates route passing by 4 different ways :
 * Car, bus, bicycle and footwork
 * counts efficiency of these ways (time spend and cost of the oil per person)
 */
public class Main {

    public static String pathToFile = File.separator  + "src" + File.separator + "main"
            + File.separator + "java" + File.separator + "coord.txt" ;

    /**
     * create list of transpot ways to pass the path
     * @return
     */
    public static TransportList createTransportList() {
        TransportList transportList = new TransportList().add(new Car(90, 6.5, 4))
                                                         .add(new Bus(70, 20, 40))
                                                         .add(new Bicycle())
                                                         .add(new Footwork());
        return transportList;
    }
    /**
     * Entry point of the program and point of handling exceptions
     * @param args
     * @throws FileNotFoundException
     * @throws NumberFormatException
     */
    public static void main ( String [] args ) throws FileNotFoundException, NumberFormatException {
        String curDir = System.getProperty("user.dir");
        Path path =new Path();
        TransportList transportList = createTransportList();
        try {
            Scanner output = new Scanner(new File(curDir + pathToFile));
            ObsessionExceptionHandler handler = new ObsessionExceptionHandler();
            path.createPath(output);
            if (handler.checkPathObsession(path.getCertainCheckpoint(0), path.getCertainCheckpoint(path.getAmountOfCheckpoints() - 1))) {
                System.out.println("Obsession: begin and end has equal coordinates ");
                System.exit(0);
            }
            DistanceCounter counter = new DistanceCounter(path);
            transportList.outputStat(counter);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Error in the number format , try to use only decimal numbers");
            System.exit(1);
        }
    }
}
