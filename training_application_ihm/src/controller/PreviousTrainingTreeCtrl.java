/*
 * 
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import model.dao.DaoFactory;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import utils.DateGroup;


/**
 * Represents the tree in the second page of the application.
 */
@SuppressWarnings("deprecation")
public class PreviousTrainingTreeCtrl implements ChangeListener<TreeItem<String>>, Observer {

	/** The date group. */
	private DateGroup dateGroup;

	/** The previous training. */
	private Training previousTraining;

	/** The previous training tree. */
	private TreeView<String> previousTrainingTree;

	/** The user. */
	private User user;

	/**
	 * Instantiates a new previous training tree ctrl.
	 *
	 * @param user the user
	 * @param previousTraining the previous training
	 * @param previousTrainingTree the previous training tree
	 * @param dateGroup the date group
	 */
	public PreviousTrainingTreeCtrl(User user, Training previousTraining, TreeView<String> previousTrainingTree,
			DateGroup dateGroup) {
		this.user = user;
		this.previousTraining = previousTraining;
		this.previousTrainingTree = previousTrainingTree;
		this.dateGroup = dateGroup;
	}

	/**
	 * Changed.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 * @param arg2 the arg 2
	 */
	@Override
	public void changed(ObservableValue<? extends TreeItem<String>> arg0, TreeItem<String> arg1,
			TreeItem<String> arg2) {
		TreeItem<String> dayItem = previousTrainingTree.getSelectionModel().getSelectedItem();
		if (dayItem.isLeaf()) {
			Integer day = Integer.parseInt(dayItem.getValue());
			TreeItem<String> monthItem = dayItem.getParent();
			Integer month = utils.Utils.getMonthInteger(monthItem.getValue());

			TreeItem<String> yearItem = monthItem.getParent();
			Integer year = Integer.parseInt(yearItem.getValue());
			Calendar calendar = new GregorianCalendar(year, month - 1, day);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				List<Serie> series = DaoFactory.getInstance().getSerieDao().getWithDateSerie(user,
						dateFormat.format(calendar.getTime()));
				Structure structure = user.getTrainingSuperSet(series, DaoFactory.getInstance());

				for (Training t : structure.getTrainingsList()) {
					previousTraining.copy(t);
				}

			} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			}
		}
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		TreeItem<String> root = new TreeItem<>();
		root.setExpanded(true);

		for (Integer year : dateGroup.getDate_list().keySet()) {
			TreeItem<String> yearItem = new TreeItem<>(year.toString());

			for (Integer month : dateGroup.getDate_list().get(year).keySet()) {
				TreeItem<String> monthItem = new TreeItem<>(utils.Utils.getMonthName(month));
				for (Integer day : dateGroup.getDate_list().get(year).get(month).keySet()) {
					TreeItem<String> dayItem = new TreeItem<>(day.toString());
					monthItem.getChildren().add(dayItem);
				}
				yearItem.getChildren().add(monthItem);
			}
			root.getChildren().add(yearItem);
		}

		previousTrainingTree.setRoot(root);
		previousTrainingTree.setShowRoot(false);
	}

}
