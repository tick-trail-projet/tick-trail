package com.ticktrail.basic;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;

import org.controlsfx.control.Notifications;

/**
 * classe gerant les erreurs
 */
public class Notification {
	private String title;
	private String text;
	private String type;

	/**
	 * constructeur
	 *
	 * @param title libellé de la notification
	 * @param text  descriptif de la notification
	 * @param type  type erreur ou success
	 */
	public Notification(String title, String text, String type) {
		this.title = title;
		this.text = text;
		this.type = type;
	}

	/**
	 * creation d'une notification
	 */
	public void runNotification() {
		File file = new File("./src/main/java/com/ticktrail/public/img/" + this.getType() + ".png");
		Image image = new Image(file.getAbsolutePath());
		Notifications notification = Notifications.create();
		ImageView image_ = new ImageView(image);
		image_.setFitHeight(50);
		image_.setFitWidth(50);
		image_.setPreserveRatio(true);
		notification.graphic(image_);
		notification.title(this.getTitle());
		notification.text(this.getText());
		notification.hideAfter(Duration.seconds(5));
		notification.position(Pos.BASELINE_RIGHT);
		notification.show();
	}

	/**
	 * obtenir le libellé
	 *
	 * @return le libellé de l'erreur
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * valorise le libellé
	 *
	 * @param title le libellé de l'erreur à prendre en compte
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * obtenir le descriptif de l'erreur
	 *
	 * @return le descriptif de l'erreur
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * valorise le descriptif de l'erreur
	 *
	 * @param text le descriptif de l'erreur à prendre en compte
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * obtenir le type de l'erreur
	 *
	 * @return le type de l'erreur
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * valorise le type de l'erreur
	 *
	 * @param type le type de l'erreur
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * obtenir l'erreur a partir de son libellé
	 *
	 * @param title le libellé
	 * @return l'erreur
	 */
	public Notification title(String title) {
		setTitle(title);
		return this;
	}

	/**
	 * obtenir l'erreur a partir de son descriptif
	 *
	 * @param text descriptif
	 * @return l'erreur
	 */
	public Notification text(String text) {
		setText(text);
		return this;
	}

	/**
	 * obtenir l'erreur a partir de son descriptif
	 *
	 * @param type le type de l'erreur
	 * @return l'erreur
	 */
	public Notification type(String type) {
		setType(type);
		return this;
	}
}
