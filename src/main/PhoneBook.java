package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PhoneBook {
	private List<Person> addressBook;

	public PhoneBook() {
        addressBook = new ArrayList<>();
    }

	public PhoneBook(List<Person> personList) {
		if (personList == null) {
			return;
		}
        this.addressBook = new ArrayList<>();

		//Adds all distinct values to list
		addressBook = personList.stream().distinct().collect(Collectors.toList());
	}

	public List<Person> getAddressBook(){
		return addressBook;
	}

	/**
	 * Add a unique person as a contact in the phone book;
	 * @param contact The person object to be added.
	 * @return True if person was added, false otherwise.
	 */
	public boolean addContact(Person contact) {
		if (contact == null) {
			return false;
		}
		if(addressBook.contains(contact)){
			return false;
		}
		return addressBook.add(contact);
	}

	/**
	 * Search the phone book and return every contact with that name.
	 * @param exactName The name that is searched for
	 * @return List<Person> a List with matching contacts
	 */
	public List<Person> findPersonByName(String exactName) {
		List<Person> resultList = new ArrayList<>();
		if (addressBook.contains(exactName)){

			for(Person person : addressBook){
				if(person.getName().equals(exactName)){
					resultList.add(person);
				}
			}
		}
		return resultList;
	}
    /**
     * Find persons with a name that matches, the search should be a little fuzzy.
     * @param name : The partial name to look for.
     * @return a List of all the contacts partially matching the name.
     */
    public List<Person> searchPersonByName(String name) {
        return null;
    }

	/**
	 * Returns the specific contact from the phone book.
	 * @param id
	 * @return
	 */
	public Person getContact(UUID id) {
		return null;
	}

    /**
     *
     * @param address : The address to compare to
     * @return a List of every contact living on the address.
     */
    public List<Person> findContactsOnSameAddress (String address) {
        return null;
    }

    /**
     *
     * @param contact : The contact with an address
     * @return a List of every contact  living on the address.
     */
    public List<Person> findContactsOnSameAddress (Person contact) {
        return null;
    }
}
