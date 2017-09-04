
public class Vehicle {

    public String registrationNumber;
    public int numberOfSeats;
    public boolean brandNew;

    public Vehicle(String registrationNumber, int numberOfSeats, boolean brandNew) {
        this.registrationNumber = registrationNumber;
        this.numberOfSeats = numberOfSeats;
        this.brandNew = brandNew;
    }

    public static void main(String[] args) {
        Vehicle lorry = new Vehicle("BN12 HTY", 3, true);
        lorry.printRegistrationNumber();
        lorry.setRegistrationNumber("NN12 3GH");
        lorry.printRegistrationNumber();
    }

    public void setRegistrationNumber(String updatedRegistration) {
        this.registrationNumber = updatedRegistration;
    }

    public void printRegistrationNumber() {
        System.out.println(registrationNumber);
    }

}








