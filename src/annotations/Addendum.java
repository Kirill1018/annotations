package annotations;
import java.util.Collection;
public class Addendum implements MedColl {
	Addendum() { }
	@Override
	public void addToColl(String behalf, Collection<String> collection) { collection.add(behalf); }
}