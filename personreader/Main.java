package fifth.personreader;

public class Main
{
	public static void main(String[] args)
	{
	    PersonSerializer pSerial = new PersonSerializer();
	    Person kalman = new Person("Kalman", "Mikorka", 32);
	    Person zoltan = new Person("Zoltan", "Par", 32);
	    Person ella = new Person("Ella", "Szalmon", 32);
	    pSerial.addPerson(kalman);
	    pSerial.addPerson(ella);
	    pSerial.addPerson(zoltan);
	    pSerial.serialize("persons.ser");
	    PersonDisplayer engDisplayer = new PersonDisplayer(Language.EN);
	    engDisplayer.display("persons.ser");
	    System.out.println();
	    PersonDisplayer hunDisplayer = new PersonDisplayer(Language.HU);
	    hunDisplayer.display("persons.ser");
	}
	
}