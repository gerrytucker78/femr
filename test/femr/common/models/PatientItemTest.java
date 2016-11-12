package femr.common.models;

import femr.data.models.mysql.Patient;
import femr.utd.tests.BaseTest;
import femr.util.calculations.dateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gtucker on 11/12/16.
 */
public class PatientItemTest extends BaseTest {
    private static PatientItem expectedPatientItem;

    @BeforeClass
    public static void setUp() throws Exception {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -4);
        Date birth = new Date();
        birth.setTime(now.getTimeInMillis());

        expectedPatientItem = new PatientItem();
        expectedPatientItem.setAddress("1234 Main Street");
        expectedPatientItem.setAge("4 MO");
        expectedPatientItem.setBirth(birth);
        expectedPatientItem.setCity("City");
        expectedPatientItem.setFirstName("FName");
        expectedPatientItem.setFriendlyDateOfBirth(dateUtils.getFriendlyDate(birth));
        expectedPatientItem.setHeightFeet(6);
        expectedPatientItem.setHeightInches(6);
        expectedPatientItem.setId(1);
        expectedPatientItem.setLastName("LName");
        expectedPatientItem.setMonthsOld(4);
        expectedPatientItem.setPathToPhoto("/dev/null");
        expectedPatientItem.setPhotoId(1);
        expectedPatientItem.setSex("M");
        expectedPatientItem.setUserId(1);
        expectedPatientItem.setWeeksPregnant(0);
        expectedPatientItem.setWeight(Float.valueOf(5));
        expectedPatientItem.setYearsOld(0);
    }

    @Test
    public void createPatientItem() throws Exception {
        // Verify nominal create patient item
        PatientItem actualPatientItem = PatientItem.createPatientItem(expectedPatientItem.getId(),
                expectedPatientItem.getFirstName(),
                expectedPatientItem.getLastName(),
                expectedPatientItem.getCity(),
                expectedPatientItem.getAddress(),
                expectedPatientItem.getUserId(),
                expectedPatientItem.getBirth(),
                expectedPatientItem.getSex(),
                expectedPatientItem.getWeeksPregnant(),
                expectedPatientItem.getHeightFeet(),
                expectedPatientItem.getHeightInches(),
                expectedPatientItem.getWeight(),
                expectedPatientItem.getPathToPhoto(),
                expectedPatientItem.getPhotoId(),
                expectedPatientItem.getAge());


        assertEquals(expectedPatientItem.getAddress(),actualPatientItem.getAddress());
        assertEquals(expectedPatientItem.getAge(),actualPatientItem.getAge());
        assertEquals(expectedPatientItem.getBirth(),actualPatientItem.getBirth());
        assertEquals(expectedPatientItem.getCity(),actualPatientItem.getCity());
        assertEquals(expectedPatientItem.getFirstName(),actualPatientItem.getFirstName());
        assertEquals(expectedPatientItem.getFriendlyDateOfBirth(),actualPatientItem.getFriendlyDateOfBirth());
        assertEquals(expectedPatientItem.getHeightFeet(),actualPatientItem.getHeightFeet());
        assertEquals(expectedPatientItem.getHeightFeetDual(),actualPatientItem.getHeightFeetDual());
        assertEquals(expectedPatientItem.getHeightInches(),actualPatientItem.getHeightInches());
        assertEquals(expectedPatientItem.getHeightInchesDual(),actualPatientItem.getHeightInchesDual());
        assertEquals(expectedPatientItem.getId(),actualPatientItem.getId());
        assertEquals(expectedPatientItem.getLastName(),actualPatientItem.getLastName());
        assertEquals(expectedPatientItem.getMonthsOld(),actualPatientItem.getMonthsOld());
        assertEquals(expectedPatientItem.getPathToPhoto(),actualPatientItem.getPathToPhoto());
        assertEquals(expectedPatientItem.getPhotoId(),actualPatientItem.getPhotoId());
        assertEquals(expectedPatientItem.getSex(),actualPatientItem.getSex());
        assertEquals(expectedPatientItem.getUserId(),actualPatientItem.getUserId());
        assertEquals(expectedPatientItem.getWeeksPregnant(),actualPatientItem.getWeeksPregnant());
        assertEquals(expectedPatientItem.getWeight(),actualPatientItem.getWeight());
        assertEquals(expectedPatientItem.getWeightDual(),actualPatientItem.getWeightDual());
        assertEquals(expectedPatientItem.getYearsOld(),actualPatientItem.getYearsOld());


    }

}