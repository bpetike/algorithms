package fifth.personreader;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonDisplayer
{
	private List<Person> personsToDisplay;
	private Language language;

	public PersonDisplayer(Language language)
	{
		personsToDisplay = new ArrayList<>();
		this.language = language;
	}

	public List<Person> getPersonsToDisplay()
	{
		return personsToDisplay;
	}

	public void display(String fileName)
	{
		personsToDisplay = deserialize(fileName);
		for (Person person : personsToDisplay)
		{
			System.out.println(getFormattedPersonData(person));
		}
	}

	private String getFormattedPersonData(Person person)
	{
		StringBuffer sb = new StringBuffer();
		switch (this.language.name())
		{
		case "EN":
			sb.append(person.getFirstName()).append(" ").append(person.getLastName());
			sb. append("\t").append(person.getAge());
			break;
		case "HU":
			sb.append(person.getLastName()).append(" ").append(person.getFirstName());
			sb. append("\t").append(person.getAge());
			break;
		}
		return sb.toString();
	}
	
	private List<Person> deserialize(String fileName)
	{
		List<Person> personsReadFromFile = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream inStream = null;
		boolean check = true;
		try
		{
			fis = new FileInputStream(new File(fileName));
			inStream = new ObjectInputStream(fis);
			while (check)
			{
				try
				{
					Person currentPerson = (Person) inStream.readObject();
					personsReadFromFile.add(currentPerson);
				} catch (EOFException e)
				{
					check = false;
				}
			}
			inStream.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return personsReadFromFile;

	}
}
