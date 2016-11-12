package femr.business.services.system;

import com.avaje.ebean.ExpressionList;
import com.google.inject.Inject;
import femr.business.helpers.QueryProvider;
import femr.business.services.core.IMissionTripService;
import femr.common.ItemModelMapper;
import femr.common.dtos.ServiceResponse;
import femr.common.models.MissionTripItem;
import femr.common.models.TripItem;
import femr.data.daos.IRepository;
import femr.data.models.core.IMissionTrip;
import femr.data.models.mysql.MissionTrip;
import femr.utd.tests.BaseTest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gtucker on 11/12/16.
 */
public class MissionTripServiceTest extends BaseTest {
    private static IMissionTripService service;
    private static MissionTripItem item;

    @Inject
    public void setService(IMissionTripService service) {
        this.service = service;
    }


    @BeforeClass
    public static void setUp() throws Exception {

    }


    @AfterClass
    public static void tearDown() throws Exception {
        if (item != null) {
            IRepository<IMissionTrip> mtr = service.getMissionTripRepository();
            ExpressionList<MissionTrip> exprl = QueryProvider.getMissionTripQuery()
                    .where()
                    .eq("id", item.getId());
            IMissionTrip result = mtr.findOne(exprl);
            mtr.delete(result);

        }

    }

    @Test
    public void createNewTrip() throws Exception {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -4);
        Date startDate = new Date();
        startDate.setTime(now.getTimeInMillis());

        now.add(Calendar.MONTH, 8);
        Date endDate = new Date();
        endDate.setTime(now.getTimeInMillis());


        TripItem inputTripItem = new TripItem();
        inputTripItem.setTeamName("ApParent Project");
        inputTripItem.setTripCity("Cotundo");
        inputTripItem.setTripCountry("Ecuador");
        inputTripItem.setTripEndDate(endDate);
        inputTripItem.setTripStartDate(startDate);

        ServiceResponse<MissionTripItem> response = service.createNewTrip(inputTripItem.getTeamName(), inputTripItem.getTripCity(), inputTripItem.getTripCountry(), inputTripItem.getTripStartDate(), inputTripItem.getTripEndDate());
        MissionTripItem actualTripItem = response.getResponseObject();
        item = actualTripItem;

        assertNotNull(actualTripItem);


        assertEquals(inputTripItem.getTeamName(),actualTripItem.getTeamName());
        assertEquals(inputTripItem.getTripCountry(),actualTripItem.getTripCountry());
        assertEquals(inputTripItem.getTripCity(),actualTripItem.getTripCity());
        assertEquals(inputTripItem.getTripStartDate(),actualTripItem.getTripStartDate());
        assertEquals(inputTripItem.getTripEndDate(), actualTripItem.getTripEndDate());


    }

}