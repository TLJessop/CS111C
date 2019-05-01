package HomeWork;

import java.util.Objects;

public class Address {

    //Instance variables
    private String street, city, state, zipCode;

    //Constructor
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    //Overridden methods

    //Written to case tolerant where it makes sense
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Address){
            Address otherAddress = (Address) obj;
            if (street.equalsIgnoreCase(otherAddress.street) && city.equalsIgnoreCase(otherAddress.city)
                && state.equalsIgnoreCase(otherAddress.state) && zipCode.equals(otherAddress.zipCode)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(street.toLowerCase(), city.toLowerCase(), state.toLowerCase(), zipCode);
    }
}// Address
