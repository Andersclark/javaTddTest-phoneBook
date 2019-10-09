package test;

import main.PhoneBook;
import main.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    public PhoneBookTest() {
        constructorTest();
        addContactTest();
        findPersonByNameTest();
        searchPersonByNameTest();
    }

    public void constructorTest() {
        constructorNoArguments();
        constructorWithAnArgument();

    }

    private void constructorNoArguments(){
        try {
            new PhoneBook();
        } catch (Exception e) {
            assert(false);
        }
        PhoneBook book = new PhoneBook();
        assert book.getAddressBook() != null;
        assert book.getAddressBook().isEmpty();

        Person p = new Person("", "", "", "", 1, new Date());
        List<Person> list = new ArrayList<>();
        list.add(p);
    }

    public void addContactTest() {
        phoneBook = new PhoneBook();
        Person p = new Person("", "", "", "",1, new Date());
        Person p2 = new Person("Something else", "", "", "", 1, new Date());

        boolean didAdd = phoneBook.addContact(p);
        assert didAdd;

        boolean didAddTheSamePerson = phoneBook.addContact(p);
        assert !didAddTheSamePerson;

        didAddTheSamePerson = phoneBook.addContact(p);
        assert !didAddTheSamePerson;

        boolean couldAddNullPerson = phoneBook.addContact(null);
        assert !couldAddNullPerson;

        assert phoneBook.getAddressBook().size() == 1;
        assert phoneBook.getAddressBook().get(0) == p;

        phoneBook.addContact(p2);
        assert phoneBook.getAddressBook().size() == 2;
        assert phoneBook.getAddressBook().containsAll(List.of(p, p2));

        didAddTheSamePerson = phoneBook.addContact(p2);
        assert didAddTheSamePerson == false;
    }

    private void constructorWithAnArgument() {
        PhoneBook book = null;
        Person p = new Person("", "", "", "", 1, new Date());
        List<Person> list = new ArrayList<>();
        list.add(p);

        try {
            book = new PhoneBook(list);
        } catch (Exception ex) {
            assert(false);
        }

        assert book.getAddressBook() != null;
        assert book.getAddressBook().size() == 1;
        assert list.containsAll(book.getAddressBook());

        try {
            var pb = new PhoneBook(null);
            assert(pb.getAddressBook() == null);
        } catch (Exception ex) {
            assert(false);
        }

        list.clear();
        assert book.getAddressBook().size() == 1;
        list.add(p);
        list.add(p);
        book = new PhoneBook(list);
        assert book.getAddressBook().size() == 1;
    }

    public void findPersonByNameTest() {
        phoneBook = new PhoneBook();

        List<Person> peopleWithTheNameHej = phoneBook.findPersonByName("Hej");
        assert (peopleWithTheNameHej.size() == 0);


        // Then add a person
        // Run the function again and assert that the size is correct
        Person p = new Person("Hej", "Address", "aasdkjasd", "19203", 1, new Date());
        phoneBook.addContact(p);
        peopleWithTheNameHej = phoneBook.findPersonByName("Hej");
        assert(peopleWithTheNameHej.size() == 0);
    }

    public void searchPersonByNameTest(){
        // Test empty searchstring
        // Should return empty list.
        phoneBook = new PhoneBook();


        String searchString = "";
        List<Person> result = phoneBook.searchPersonByName(searchString);
        assert(result.isEmpty());

        // Test searchstring with no match
        // Should return empty list (no match)
        searchString = "Hej";
        result = phoneBook.searchPersonByName(searchString);
        assert(result.size()==0);

        // Test searchstring with match
        // Should return list containing matching Person
        Person p = new Person("Hej", "","","",1,new Date());
        phoneBook.addContact(p);
        result = phoneBook.searchPersonByName(searchString);


    }

    public void getContactTest() {}

    public void findContactsOnSameAddressTest() {}
}
