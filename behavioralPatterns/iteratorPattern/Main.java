package iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Collection interface
interface MyCollection<T> {
	void addItem(T item);

	void removeItem(T item);

	Iterator<T> createIterator();
}

// Concrete Collection class
class MyList<T> implements MyCollection<T> {
	private List<T> items = new ArrayList<>();

	@Override
	public void addItem(T item) {
		items.add(item);
	}

	@Override
	public void removeItem(T item) {
		items.remove(item);
	}

	@Override
	public Iterator<T> createIterator() {
		return items.iterator();
	}
}

public class Main {
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyList<>();
		myCollection.addItem("Apple");
		myCollection.addItem("Banana");
		myCollection.addItem("Cherry");

		Iterator<String> iterator = myCollection.createIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}