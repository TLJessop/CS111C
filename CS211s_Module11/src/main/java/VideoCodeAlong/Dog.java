package VideoCodeAlong;

public class Dog {

    //Class variable
    private static int countOfDogs = 0;

    //Instance variables
    private String name, breed;
    private int age;
    private boolean vaccinated;

    //Constructor
    public Dog(String name, String breed, int age, boolean vaccinated){
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.vaccinated = vaccinated;
        countOfDogs++;
    }

    //Static method
    public int getDogCount(){
        return countOfDogs;
    }

    //Getters and Setters
    public static int getCountOfDogs() {
        return countOfDogs;
    }

    public static void setCountOfDogs(int countOfDogs) {
        Dog.countOfDogs = countOfDogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

}//Dog
