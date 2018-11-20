package decorator;

public abstract class Cloth extends Person {
    private Person person;


    public Cloth(Person p){
        this.person = p;
    }

    @Override
    public void dressed() {
        person.dressed();
    }
}
