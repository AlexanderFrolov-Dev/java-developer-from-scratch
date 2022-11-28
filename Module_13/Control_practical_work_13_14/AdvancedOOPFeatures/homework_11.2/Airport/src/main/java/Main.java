import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Date currentDate = new Date();
        long TWO_HOURS = 7_200_000;
        System.out.println(currentDate.getTime());
        long twoHoursEarlier = currentDate.getTime() - TWO_HOURS;
        System.out.println(twoHoursEarlier);

        for (Flight flight : findPlanesLeavingInTheNextTwoHours(Airport.getInstance())) {
            System.out.println(flight);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должен вернуть список рейсов вылетающих в ближайшие два часа.
        long TWO_HOURS = 7_200_000;

        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getDate().getTime() <= (new Date().getTime() + TWO_HOURS))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }

}