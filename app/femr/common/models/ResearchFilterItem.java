/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.common.models;

import femr.ui.models.research.FilterViewModel;

import java.util.List;

public class ResearchFilterItem {

    private String primaryDataset;
    private String secondaryDataset;
    private String graphType;
    private String startDate;
    private String endDate;
    private boolean groupPrimary;
    private Integer groupFactor;
    private Float filterRangeStart;
    private Float filterRangeEnd;
    private String medicationName;
    private String orderBy;
    private Integer MissionTripId; // Andrew Trip Filter

    public String getPrimaryDataset() {
        return primaryDataset;
    }

    public void setPrimaryDataset(String primaryDataset) {
        this.primaryDataset = primaryDataset;
    }

    public String getSecondaryDataset() {
        return secondaryDataset;
    }

    public void setSecondaryDataset(String secondaryDataset) {
        this.secondaryDataset = secondaryDataset;
    }

    public String getGraphType() {
        return graphType;
    }

    public void setGraphType(String graphType) {
        this.graphType = graphType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isGroupPrimary() { return groupPrimary; }

    public void setGroupPrimary(boolean groupPrimary) { this.groupPrimary = groupPrimary; }

    public Integer getGroupFactor() { return groupFactor; }

    public void setGroupFactor(Integer groupFactor) { this.groupFactor = groupFactor; }

    public Float getFilterRangeStart() { return filterRangeStart; }

    public void setFilterRangeStart(Float filterRangeStart) {

        if (filterRangeStart == null) {

            this.filterRangeStart = -1 * Float.MAX_VALUE;

        } else {

            this.filterRangeStart = filterRangeStart;
        }
    }

    public Float getFilterRangeEnd() { return filterRangeEnd; }

    public void setFilterRangeEnd(Float filterRangeEnd) {

        if (filterRangeEnd == null) {

            this.filterRangeEnd = Float.MAX_VALUE;

        } else {

            this.filterRangeEnd = filterRangeEnd;
        }
    }

    public String getMedicationName() { return medicationName; }

    public void setMedicationName(String medicationName) { this.medicationName = medicationName; }

    public Integer getMissionTripId() { return MissionTripId; } //Andrew Trip Filter

    public void setMissionTripId(Integer MissionTripId) { this.MissionTripId = MissionTripId; } //Andrew Trip Filter

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * Generate and provide an instance of ResearchFilterItem.
     * Moved from an implementation of IItemModelMapper on 6-10-2015 by Kevin
     *
     * @param primaryDataSet
     * @param secondaryDataSet
     * @param graphType
     * @param startDate
     * @param endDate
     * @param groupFactor
     * @param groupPrimary
     * @param filterRangeStart
     * @param filterRangeEnd
     * @param medicationName
     * @param missionTripId
     * @return
     */
    public static ResearchFilterItem createResearchFilterItem(FilterViewModel fvm) {

        if (fvm == null) {
            return null;
        }

        String primaryDataSet = fvm.getPrimaryDataset();
        String secondaryDataSet = fvm.getSecondaryDataset();
        String graphType = fvm.getGraphType();
        String startDate = fvm.getStartDate();
        String endDate = fvm.getEndDate();
        Integer groupFactor = fvm.getGroupFactor();
        Boolean groupPrimary = fvm.isGroupPrimary();
        Float filterRangeStart = fvm.getFilterRangeStart();
        Float filterRangeEnd = fvm.getFilterRangeEnd();
        String medicationName = fvm.getMedicationName();
        Integer missionTripId = fvm.getMissionTripId();

        ResearchFilterItem filterItem = new ResearchFilterItem();



        filterItem.setPrimaryDataset(primaryDataSet);
        filterItem.setSecondaryDataset(secondaryDataSet);
        filterItem.setGraphType(graphType);
        filterItem.setStartDate(startDate);
        filterItem.setEndDate(endDate);

        filterItem.setGroupFactor(groupFactor);
        if (groupFactor != null && groupFactor > 0) {

            filterItem.setGroupPrimary(groupPrimary);
        } else {

            filterItem.setGroupPrimary(false);
        }

        filterItem.setFilterRangeStart(filterRangeStart);
        filterItem.setFilterRangeEnd(filterRangeEnd);
        filterItem.setMedicationName(medicationName);
        filterItem.setMissionTripId(missionTripId); //Andrew Trip Filter




        return filterItem;
    }

}
