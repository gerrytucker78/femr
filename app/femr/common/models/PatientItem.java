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

import femr.util.calculations.dateUtils;
import femr.util.stringhelpers.StringUtils;

import java.util.Date;



public class PatientItem {
    private int Id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String age;//this is a string representing an integer and "YO"(adult) or "MO"(infant)
    private Integer yearsOld;//the age of the patient as an integer. 0 if the patient is less than a year old
    private Integer monthsOld;
    private Date birth;
    private String friendlyDateOfBirth;
    private String sex;
    private Integer photoId;
    private String pathToPhoto;
    private int userId;
    private Integer weeksPregnant;
    private Integer heightFeet;
    private Integer heightInches;
   //added for femr-136 - dual unit display
    private Integer heightFeetDual;
    private Integer heightInchesDual;

    private Float weight;
    //added for femr-136 - dual unit display
    private Float weightDual;

    public PatientItem(){
        //default empty values
        this.Id = 0;
        this.pathToPhoto = "";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getWeeksPregnant() {
        return weeksPregnant;
    }

    public void setWeeksPregnant(Integer weeksPregnant) {
        this.weeksPregnant = weeksPregnant;
    }

    public Integer getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(Integer heightFeet) {
        this.heightFeet = heightFeet;
    }

    public Integer getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(Integer heightInches) {
        this.heightInches = heightInches;
    }

    public Integer getHeightFeetDual() {
        return heightFeetDual;
    }

    public void setHeightFeetDual(Integer heightFeetDual) {
        this.heightFeetDual = heightFeetDual;
    }

    public Integer getHeightInchesDual() {
        return heightInchesDual;
    }

    public void setHeightInchesDual(Integer heightInchesDual) {
        this.heightInchesDual = heightInchesDual;
    }


    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getWeightDual() {
        return weightDual;
    }

    public void setWeightDual(Float weightDual) {
        this.weightDual = weightDual;
    }

    public String getFriendlyDateOfBirth() {
        return friendlyDateOfBirth;
    }

    public void setFriendlyDateOfBirth(String friendlyDateOfBirth) {
        this.friendlyDateOfBirth = friendlyDateOfBirth;
    }

    public Integer getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(Integer yearsOld) {
        this.yearsOld = yearsOld;
    }

    public Integer getMonthsOld() {
        return monthsOld;
    }

    public void setMonthsOld(Integer monthsOld) {
        this.monthsOld = monthsOld;
    }

    /**
     * Generate and provide an instance of PatientItem. See parameter descriptions for which fields must be filled out.
     *
     * @param id                 id of the patient, not null
     * @param firstName          first name of the patient, not null
     * @param lastName           last name of the patient, not null
     * @param city               city that the patient lives in, not null
     * @param address            address of the patient, may be null
     * @param userId             id of the user that checked in the patient in triage, not null
     * @param age                age of the patient, may be null
     * @param sex                sex of the patient, may be null
     * @param weeksPregnant      how many weeks pregnant the patient is, may be null
     * @param heightFeet         how tall the patient is, may be null
     * @param heightInches       how tall the patient is, may be null
     * @param weight             how much the patient weighs, may be null
     * @param pathToPatientPhoto filepath to the patient photo, may be null
     * @param photoId            id of the patients photo, may be null
     * @param ageClassification  age classification of the patient (adult,child, etc), may be null
     * @return a new PatientItem or null if processing fails, may be null
     */
    public static PatientItem createPatientItem(int id,
                                  String firstName,
                                  String lastName,
                                  String city,
                                  String address,
                                  int userId,
                                  Date age,
                                  String sex,
                                  Integer weeksPregnant,
                                  Integer heightFeet,
                                  Integer heightInches,
                                  Float weight,
                                  String pathToPatientPhoto,
                                  Integer photoId,
                                  String ageClassification) {
        if (StringUtils.isNullOrWhiteSpace(firstName) ||
                StringUtils.isNullOrWhiteSpace(lastName) ||
                StringUtils.isNullOrWhiteSpace(city)) {

            return null;
        }

        PatientItem patientItem = new PatientItem();

        //required fields
        patientItem.setId(id);
        patientItem.setFirstName(firstName);
        patientItem.setLastName(lastName);
        patientItem.setYearsOld(dateUtils.getYearsInteger(age));
        patientItem.setMonthsOld(dateUtils.getMonthsInteger(age));
        patientItem.setCity(city);
        patientItem.setUserId(userId);
        //optional fields
        if (StringUtils.isNotNullOrWhiteSpace(address))
            patientItem.setAddress(address);
        if (StringUtils.isNotNullOrWhiteSpace(sex))
            patientItem.setSex(sex);
        if (age != null) {

            patientItem.setAge(dateUtils.getAge(age));//age (int)
            patientItem.setBirth(age);//date of birth(date)
            patientItem.setFriendlyDateOfBirth(dateUtils.getFriendlyDate(age));

        }
        if (StringUtils.isNotNullOrWhiteSpace(pathToPatientPhoto) && photoId != null) {

            patientItem.setPathToPhoto(pathToPatientPhoto);
            patientItem.setPhotoId(photoId);
        }
        if (weeksPregnant != null)
            patientItem.setWeeksPregnant(weeksPregnant);

        if (heightFeet != null)
            patientItem.setHeightFeet(heightFeet);
        else
            patientItem.setHeightFeet(0);

        if (heightInches != null)
            patientItem.setHeightInches(heightInches);
        else
            patientItem.setHeightInches(0);

        if (weight != null)
            patientItem.setWeight(weight);

        return patientItem;

    };

}
