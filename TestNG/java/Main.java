import tat.bsu.route.ObsessionHandler;
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
     * list of constant parameters of all transports in the program
     */
    public static final double carSpeed = 90;
    public static final double carConsumption100Km = 6.5;
    public static final int carNumberOfPassangers = 4;

    public static final double busSpeed = 70;
    public static final double busConsumption100Km = 20;
    public static final int busNumberOfPassangers = 40;

    public static final double bicycleSpeed = 30;
    public static final double footworkSpeed = 5;

    /**
     * find and get file with coordinates list
     * @return
     * @throws FileNotFoundException
     */
    public static Scanner getOutputFile() throws FileNotFoundException {
        String curDir = System.getProperty("user.dir");
        Scanner output = new Scanner(new File(curDir + pathToFile));
        return  output;
    }

    /**
     * create list of transpot ways to pass the path
     * @return
     */
    public static TransportList createTransportList() {
        TransportList transportList = new TransportList().add(new Car(carSpeed, carConsumption100Km, carNumberOfPassangers))
                                                         .add(new Bus(busSpeed, busConsumption100Km, busNumberOfPassangers))
                                                         .add(new Bicycle(bicycleSpeed))
                                                         .add(new Footwork(footworkSpeed));
        return transportList;
    }
    /**
     * Entry point of the program and point of handling exceptions
     * @param args
     * @throws NumberFormatException
     */
    public static void main ( String [] args ) throws NumberFormatException {
        try {
            TransportList transportList = createTransportList();
            Path path =new Path();
            path.createPath(getOutputFile());
            DistanceCounter counter = new DistanceCounter();
            counter.findWholeDistance(path);

            ObsessionHandler handler = new ObsessionHandler();
            if (handler.checkPathObsession(path.getCertainCheckpoint(0), path.getCertainCheckpoint(path.getAmountOfCheckpoints() - 1))) {
                System.out.println("Obsession: begin and end has equal coordinates ");
                System.exit(1);
            }

            transportList.outputStat(counter);
            getOutputFile().close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Error in the coordinates format , try to input at least one and use only decimal numbers ");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error, try to use numbers in operable range ( <sqrt(MAX_VALUE) ) ");
            System.exit(1);
        }
    }
}
