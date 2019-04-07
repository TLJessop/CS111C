package VideoCodeAlong;

import java.util.Objects;

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

    //Overridden methods
    @Override
    public boolean equals(Object obj){
        if (obj == null ) return false;
        if (obj == this ) return true;
        if (obj.getClass() == Dog.class){
            Dog other = (Dog) obj;

            if (this.name.equalsIgnoreCase(other.name) && this.breed.equalsIgnoreCase(other.breed)
                && this.age == other.age && this.vaccinated == other.vaccinated){
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
       return Objects.hash(name, breed, age, vaccinated);
    }


}//Dog
