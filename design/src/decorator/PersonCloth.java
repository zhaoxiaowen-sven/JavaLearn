package decorator;

public class PersonCloth extends Person {
    private Person person;

    public PersonCloth(Person p){
        this.person = p;
    }

    @Override
    public void dressed() {
        person.dressed();
    }
}
