package org.soa.ws.tp4;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "org.soa.ws.tp4.PersonService")
public class PersonServiceImpl implements PersonService{
	
	private ArrayList<String> persons;
	
	public PersonServiceImpl() {
		persons = new ArrayList<String>();
		persons.add("Nom 1");
		persons.add("Nom 2");
		persons.add("Nom 3");
		persons.add("Nom 4");
	}

	@Override
	@WebMethod
	public String getPersonId(String personName) {
		for(int i=0; i<persons.size(); i++)
			if(personName.equals(persons.get(i)))
				return Integer.toString(i);
		return null;
	}

	@Override
	@WebMethod
	public ArrayList<String> getPersonIdList(ArrayList<String> personNameList) {
		ArrayList<String> personIdList = new ArrayList<String>();
		for(int i=0; i<personNameList.size(); i++)
			for(int j=0; j<persons.size(); j++)
				if(personNameList.get(i).equals(persons.get(j)))
			        personIdList.add(Integer.toString(j));
		return personIdList;
	}

}
