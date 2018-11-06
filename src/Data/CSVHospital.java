package Data;

import com.opencsv.bean.CsvBindByName;

public class CSVHospital {
    @CsvBindByName(column = "Provider ID")
    private String providerID;

    @CsvBindByName(column = "Hospital Name")
    private String name;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "City")
    private String city;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Zip Code")
    private String zipCode;

    @CsvBindByName(column = "County Name")
    private String county;

    @CsvBindByName(column = "Phone Number")
    private String phoneNum;

    @CsvBindByName(column = "Hospital Type")
    private String type;

    @CsvBindByName(column = "Hospital Ownership")
    private String ownership;

    @CsvBindByName(column = "Emergency Services")
    private String emergency;

    @CsvBindByName(column = "Meets criteria for meaningful use of EHRs")
    private String erhs;

    @CsvBindByName(column = "Hospital overall rating")
    private String rating;

    @CsvBindByName(column = "Mortality national comparison")
    private String mortality;

    @CsvBindByName(column = "Safety of care national comparison")
    private String safety;

    @CsvBindByName(column = "Readmission national comparison")
    private String readmit;

    @CsvBindByName(column = "Patient experience national comparison")
    private String experience;

    @CsvBindByName(column = "Effectiveness of care national comparison")
    private String effective;

    @CsvBindByName(column = "Timeliness of care national comparison")
    private String timeliness;

    @CsvBindByName(column = "Efficient use of medical imaging national comparison")
    private String efficientImage;


    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getErhs() {
        return erhs;
    }

    public void setErhs(String erhs) {
        this.erhs = erhs;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMortality() {
        return mortality;
    }

    public void setMortality(String mortality) {
        this.mortality = mortality;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getReadmit() {
        return readmit;
    }

    public void setReadmit(String readmit) {
        this.readmit = readmit;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getTimeliness() {
        return timeliness;
    }

    public void setTimeliness(String timeliness) {
        this.timeliness = timeliness;
    }

    public String getEfficientImage() {
        return efficientImage;
    }

    public void setEfficientImage(String efficientImage) {
        this.efficientImage = efficientImage;
    }
}