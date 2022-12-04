import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

public class TestRouteCalculator extends TestCase {
    StationIndex stationIndex = new StationIndex();
    @Override
    protected void setUp() throws Exception {


        Line firstLine = new Line(1, "First Line");
        Line secondLine = new Line(2, "Second Line");
        Line thirdLine = new Line(3, "Third Line");

        Station pushkina = new Station("Пушкина", firstLine);
        Station tolstogo = new Station("Толстого", firstLine);
        Station lermontova = new Station("Лермонтова", firstLine);
        Station dostoevskogo = new Station("Достоевского", firstLine);
        Station nevskogo = new Station("Невского", secondLine);
        Station suvorova = new Station("Суворова", secondLine);
        Station kutuzova = new Station("Кутузова", secondLine);
        Station zhukova = new Station("Жукова", secondLine);
        Station severnaya = new Station("Северная", thirdLine);
        Station severoZapadnaya = new Station("Северо-Западная", thirdLine);
        Station centralnaya = new Station("Центральная", thirdLine);
        Station yugoVostochnaya = new Station("Юго-Восточная", thirdLine);
        Station yuzhnaya = new Station("Южная", thirdLine);

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

        stationIndex.addConnection(null);
    }

    @Test
    public void testCalculateDuration() {

    }

    private void addStationsInStationIndex(Line line) {
        for (int i = 0; i < line.getStations().size(); i++) {
            stationIndex.addStation(line.getStations().get(i));
        }
    }
}
