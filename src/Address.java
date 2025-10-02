import java.util.StringJoiner;

public class Address {
    public Address(String streetInfo, String city, String postalCode, String province, String country) {
        this.streetInfo = streetInfo;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public String getStreetInfo() {
        return streetInfo;
    }

    public void setStreetInfo(String streetInfo) {
        this.streetInfo = streetInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("streetInfo='" + streetInfo + "'")
                .add("city='" + city + "'")
                .add("postalCode='" + postalCode + "'")
                .add("province='" + province + "'")
                .add("country='" + country + "'")
                .toString();
    }

    private String streetInfo;
    private String city;
    private String postalCode;
    private String province;
    private String country;



}
