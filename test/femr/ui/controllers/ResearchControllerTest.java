package femr.ui.controllers;

import femr.common.models.ResearchFilterItem;
import femr.ui.models.research.FilterViewModel;
import femr.utd.tests.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gtucker on 11/12/16.
 */
public class ResearchControllerTest extends BaseTest {
    @Test
    public void createResearchFilterItem() throws Exception {
        FilterViewModel fvm = new FilterViewModel();
        fvm.setPrimaryDataset("Primary");
        fvm.setSecondaryDataset("Secondary");
        fvm.setGraphType("Graph");
        fvm.setStartDate("Start Date");
        fvm.setEndDate("End Date");
        fvm.setGroupFactor(1);
        fvm.setGroupPrimary(true);
        fvm.setFilterRangeStart(Float.parseFloat("1"));
        fvm.setFilterRangeEnd(Float.parseFloat("2"));
        fvm.setMedicationName("Medication");
        fvm.setMissionTripId(Integer.getInteger("1"));

        ResearchFilterItem rfi = ResearchController.createResearchFilterItem(fvm);

        assertEquals(fvm.getPrimaryDataset(),rfi.getPrimaryDataset());
        assertEquals(fvm.getSecondaryDataset(),rfi.getSecondaryDataset());
        assertEquals(fvm.getGraphType(),rfi.getGraphType());
        assertEquals(fvm.getStartDate(),rfi.getStartDate());
        assertEquals(fvm.getEndDate(),rfi.getEndDate());
        assertEquals(fvm.getGroupFactor(),rfi.getGroupFactor());
        assertEquals(fvm.isGroupPrimary(),rfi.isGroupPrimary());
        assertEquals(fvm.getFilterRangeStart(),rfi.getFilterRangeStart());
        assertEquals(fvm.getFilterRangeEnd(),rfi.getFilterRangeEnd());
        assertEquals(fvm.getMedicationName(),rfi.getMedicationName());
        assertEquals(fvm.getMissionTripId(),rfi.getMissionTripId());



    }

}