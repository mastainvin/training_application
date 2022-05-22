/**
 *
 */
package model.objects;

import java.util.List;

import model.objects.exceptions.NotFindInArrayException;

/**
 * The Class TrainingComponentList.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingComponentList {

	/**
	 * Gets the element by layout.
	 *
	 * @param trainingComponentList the training component list
	 * @param layout                the layout
	 * @return the element by layout
	 * @throws NotFindInArrayException the not find in array exception
	 */
	public static TrainingComponent getElementByLayout(List<TrainingComponent> trainingComponentList, Integer layout)
			throws NotFindInArrayException {
		for (TrainingComponent tc : trainingComponentList) {
			if (tc.getLayout() == layout) {
				return tc;
			}
		}
		throw new NotFindInArrayException();
	}
}
