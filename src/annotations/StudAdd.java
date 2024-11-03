package annotations;
import java.util.ArrayList;
public class StudAdd implements StudList {
	StudAdd() { }
	@Override
	public void addToList(ArrayList<Integer> estimates, int estimation) { estimates.add(estimation); }
}