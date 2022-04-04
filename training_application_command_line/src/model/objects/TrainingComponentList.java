/**
 * 
 */
package model.objects;

import java.util.ArrayList;
import java.util.List;

import model.objects.exceptions.NotFindInArrayException;

/**
 * @author cytech
 *
 */
public class TrainingComponentList  {

	public static TrainingComponent getElementByLayout(List<TrainingComponent> trainingComponentList, Integer layout) throws NotFindInArrayException {
		for(TrainingComponent tc : trainingComponentList) {
			if (tc.getLayout() == layout) {
				return tc;
			}
		}
		throw new NotFindInArrayException();
	}
}
