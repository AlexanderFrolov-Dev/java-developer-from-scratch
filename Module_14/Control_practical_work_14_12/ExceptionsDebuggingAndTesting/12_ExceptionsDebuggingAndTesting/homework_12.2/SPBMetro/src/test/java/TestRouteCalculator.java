import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {
    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    List<Station> connectedStations1And3Lines;
    List<Station> connectedStations2And3Lines;
    List<Station> route;
    List<Station> transfer;
    List<Station> withoutTransfer;
    Line firstLine;
    Line secondLine;
    Line thirdLine;

    Station pushkina;
    Station tolstogo;
    Station lermontova;
    Station dostoevskogo;
    Station nevskogo;
    Station suvorova;
    Station kutuzova;
    Station zhukova;
    Station severnaya;
    Station severoZapadnaya;
    Station centralnaya;
    Station yugoVostochnaya;
    Station yuzhnaya;

    @Override
    protected void setUp() {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);
        route = new ArrayList<>();

        Line firstLine = new Line(1, "First Line");
        Line secondLine = new Line(2, "Second Line");
        Line thirdLine = new Line(3, "Third Line");

        pushkina = new Station("Пушкина", firstLine);
        tolstogo = new Station("Толстого", firstLine);
        lermontova = new Station("Лермонтова", firstLine);
        dostoevskogo = new Station("Достоевского", firstLine);
        nevskogo = new Station("Невского", secondLine);
        suvorova = new Station("Суворова", secondLine);
        kutuzova = new Station("Кутузова", secondLine);
        zhukova = new Station("Жукова", secondLine);
        severnaya = new Station("Северная", thirdLine);
        severoZapadnaya = new Station("Северо-Западная", thirdLine);
        centralnaya = new Station("Центральная", thirdLine);
        yugoVostochnaya = new Station("Юго-Восточная", thirdLine);
        yuzhnaya = new Station("Южная", thirdLine);

        connectedStations1And3Lines = List.of(dostoevskogo, severoZapadnaya);
        connectedStations2And3Lines = List.of(suvorova, yugoVostochnaya);

        firstLine.getStations().add(pushkina);
        firstLine.getStations().add(tolstogo);
        firstLine.getStations().add(lermontova);
        firstLine.getStations().add(dostoevskogo);
        secondLine.getStations().add(nevskogo);
        secondLine.getStations().add(suvorova);
        secondLine.getStations().add(kutuzova);
        secondLine.getStations().add(zhukova);
        thirdLine.getStations().add(severnaya);
        thirdLine.getStations().add(severoZapadnaya);
        thirdLine.getStations().add(centralnaya);
        thirdLine.getStations().add(yugoVostochnaya);
        thirdLine.getStations().add(yuzhnaya);

        stationIndex.addLine(firstLine);
        stationIndex.addLine(secondLine);
        stationIndex.addLine(thirdLine);

        addStationsInStationIndex(firstLine);
        addStationsInStationIndex(secondLine);
        addStationsInStationIndex(thirdLine);

        stationIndex.addConnection(connectedStations1And3Lines);
        stationIndex.addConnection(connectedStations2And3Lines);

        route.add(lermontova);
        route.add(dostoevskogo);
        route.add(severoZapadnaya);
        route.add(centralnaya);
        route.add(yugoVostochnaya);
        route.add(suvorova);
        route.add(kutuzova);

        transfer = List.of(dostoevskogo, severoZapadnaya);
        withoutTransfer = List.of(pushkina, tolstogo);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteViaConnectedLine() {
        List<Station> actual = routeCalculator.getShortestRoute(pushkina, lermontova);
        List<Station> expected = List.of(pushkina, tolstogo, lermontova);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(lermontova, centralnaya);
        List<Station> expected = List.of(lermontova, dostoevskogo, severoZapadnaya, centralnaya);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(lermontova, kutuzova);
        List<Station> expected = List.of(lermontova, dostoevskogo, severoZapadnaya, centralnaya, yugoVostochnaya,
                suvorova, kutuzova);
        assertEquals(expected, actual);
    }

    private void addStationsInStationIndex(Line line) {
        for (int i = 0; i < line.getStations().size(); i++) {
            stationIndex.addStation(line.getStations().get(i));
        }
    }
}
