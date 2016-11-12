package femr.common;

import femr.common.models.CityItem;
import femr.common.models.MissionTripItem;
import femr.common.models.PatientItem;
import femr.data.models.core.IMissionCity;
import femr.data.models.core.IMissionCountry;
import femr.data.models.core.IMissionTeam;
import femr.data.models.core.IMissionTrip;
import femr.data.models.mysql.MissionCity;
import femr.data.models.mysql.MissionCountry;
import femr.data.models.mysql.MissionTeam;
import femr.data.models.mysql.MissionTrip;
import femr.utd.tests.BaseTest;
import femr.util.calculations.dateUtils;
import femr.util.stringhelpers.StringUtils;
import org.junit.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gtucker on 11/12/16.
 */
public class ItemModelMapperTest extends BaseTest {

    private static CityItem expectedCityItem;
    private static MissionTripItem expectedMissionTripItem = new MissionTripItem();

    private static String CITY_NAME = "Test City Name";
    private static String COUNTRY_NAME = "USA";


    private static ItemModelMapper imm = new ItemModelMapper();

    @BeforeClass
    public static void setUp() throws Exception {
        expectedCityItem = new CityItem();
        expectedCityItem.setCityName(CITY_NAME);
        expectedCityItem.setCountryName(COUNTRY_NAME);

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -4);
        Date startDate = new Date();
        startDate.setTime(now.getTimeInMillis());

        now.add(Calendar.MONTH, 8);
        Date endDate = new Date();
        endDate.setTime(now.getTimeInMillis());


        expectedMissionTripItem.setFriendlyTripEndDate(dateUtils.getFriendlyDate(endDate));
        expectedMissionTripItem.setFriendlyTripStartDate(dateUtils.getFriendlyDate(startDate));
        expectedMissionTripItem.setId(0);
        expectedMissionTripItem.setTeamName("Team");
        expectedMissionTripItem.setTripCity("City");
        expectedMissionTripItem.setTripCountry("Country");
        expectedMissionTripItem.setTripEndDate(endDate);
        expectedMissionTripItem.setTripStartDate(startDate);

        expectedMissionTripItem.setFriendlyTripTitle(StringUtils.generateMissionTripTitle(expectedMissionTripItem.getTeamName(), expectedMissionTripItem.getTripCountry(), expectedMissionTripItem.getTripStartDate(), expectedMissionTripItem.getTripEndDate()));

    }



    @AfterClass
    public static void tearDown() throws Exception {

    }

    @Test
    public void createCityItem() throws Exception {
        // Verify nominal create city item
        CityItem actualCityItem = imm.createCityItem(CITY_NAME, COUNTRY_NAME);
        assertEquals("City Name", expectedCityItem.getCityName(), actualCityItem.getCityName());

        assertEquals("Country Name", expectedCityItem.getCountryName(), actualCityItem.getCountryName());

    }

    @Test
    public void createMissionTripItem() throws Exception {
        // Verify nominal create mission trip item
        IMissionTrip trip = new MissionTrip();
        IMissionCity city = new MissionCity();
        IMissionCountry country = new MissionCountry();
        country.setName(expectedMissionTripItem.getTripCountry());
        city.setName(expectedMissionTripItem.getTripCity());
        city.setMissionCountry(country);

        IMissionTeam team = new MissionTeam();
        team.setName(expectedMissionTripItem.getTeamName());

        trip.setEndDate(expectedMissionTripItem.getTripEndDate());
        trip.setMissionCity(city);
        trip.setMissionTeam(team);
        trip.setStartDate(expectedMissionTripItem.getTripStartDate());


        MissionTripItem actualMissionTripItem = imm.createMissionTripItem(trip);

        assertEquals(expectedMissionTripItem.getId(), actualMissionTripItem.getId());
        assertEquals(expectedMissionTripItem.getFriendlyTripEndDate(), actualMissionTripItem.getFriendlyTripEndDate());
        assertEquals(expectedMissionTripItem.getFriendlyTripStartDate(), actualMissionTripItem.getFriendlyTripStartDate());
        assertEquals(expectedMissionTripItem.getFriendlyTripTitle(), actualMissionTripItem.getFriendlyTripTitle());
        assertEquals(expectedMissionTripItem.getTeamName(), actualMissionTripItem.getTeamName());
        assertEquals(expectedMissionTripItem.getTripCity(), actualMissionTripItem.getTripCity());
        assertEquals(expectedMissionTripItem.getTripCountry(), actualMissionTripItem.getTripCountry());
        assertEquals(expectedMissionTripItem.getTripEndDate(), actualMissionTripItem.getTripEndDate());
        assertEquals(expectedMissionTripItem.getTripStartDate(), actualMissionTripItem.getTripStartDate());

    }


}