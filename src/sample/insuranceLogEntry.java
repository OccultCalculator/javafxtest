package sample;

public class insuranceLogEntry {
    private int policyID;
    private String statecode;
    private String county;
    private String eqSiteLimit;

    public insuranceLogEntry(int policyID, String statecode, String county, String eqSiteLimit) {
        this.policyID = policyID;
        this.statecode = statecode;
        this.county = county;
        this.eqSiteLimit = eqSiteLimit;
    }

    public int getPolicyID() {
        return policyID;
    }

    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getEqSiteLimit() {
        return eqSiteLimit;
    }

    public void setEqSiteLimit(String eqSiteLimit) {
        this.eqSiteLimit = eqSiteLimit;
    }
}
