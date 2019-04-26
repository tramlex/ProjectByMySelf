package model;

import org.springframework.stereotype.Repository;
import restControllers.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class PersonModelDao {
    private static final Map<String,PersonModel> personMap = new HashMap<String, PersonModel>();

    static{
        initPersn();
    }

    private static void initPersn(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.get2DigitYearStart();
        PersonModel per1 = new PersonModel(1,"Alex",date);
        PersonModel per2 = new PersonModel(2,"Egor",date);
        PersonModel per3 = new PersonModel(3,"Sergey",date);

        personMap.put(per1.getName(),per1);
        personMap.put(per2.getName(),per2);
        personMap.put(per3.getName(),per3);
    }

    public PersonModel getPerson(String name){return personMap.get(name);}

    public PersonModel addPerson(PersonModel per){
        personMap.put(per.getName(),per);
        return per;
    }

    public PersonModel updatePerson(PersonModel per){
        personMap.put(per.getName(),per);
        return per;
    }

    public void deletePerson(String name){personMap.remove(name);}

    public List<PersonModel> getAllPerson(){
        Collection<PersonModel> c = personMap.values();
        List<PersonModel> list = new ArrayList<PersonModel>();
        list.addAll(c);
        return list;
    }
}
