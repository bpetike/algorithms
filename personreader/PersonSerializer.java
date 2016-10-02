package fifth.personreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonSerializer {
    private List<Person> persons;

    public PersonSerializer() {
	persons = new ArrayList<>();
    }
    
    public List<Person> getPersons()
    {
	return persons;
    }
    
    public void addPerson(Person person)
    {
	persons.add(person);
    }
    
    public void serialize(String fileName)
    {
	FileOutputStream fos = null;
	ObjectOutputStream outStream = null;
	try {
	    fos = new FileOutputStream(new File(fileName));
	    outStream = new ObjectOutputStream(fos);
	    for (Person person : persons) {
		outStream.writeObject(person);
	    }
	    outStream.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}
