package femr.common;

import femr.common.models.CityItem;
import femr.common.models.PatientItem;
import femr.utd.tests.BaseTest;
import femr.util.calculations.dateUtils;
import org.junit.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gtucker on 11/12/16.
 */
public class ItemModelMapperTest extends BaseTest {

    private static CityItem expectedCityItem;
    private static String CITY_NAME = "Test City Name";
    private static String COUNTRY_NAME = "USA";


    private static ItemModelMapper imm = new ItemModelMapper();

    @BeforeClass
    public static void setUp() throws Exception {
        expectedCityItem = new CityItem();
        expectedCityItem.setCityName(CITY_NAME);
        expectedCityItem.setCountryName(COUNTRY_NAME);
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


}