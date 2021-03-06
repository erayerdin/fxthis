package fxthis.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * <p>A helper abstract class for JavaFX controllers, which already implements Initializable.</p>
 *
 * @see Initializable
 */
public abstract class GenericController implements Initializable {
    /**
     * Gets scene.
     *
     * @see javafx.scene.Scene
     * @param event
     * @return Scene of current controller.
     */
    public Scene getScene(ActionEvent event) {
        Node source = (Node) event.getSource();
        return source.getScene();
    }

    /**
     * Gets window by calling getScene.
     *
     * @see GenericController#getScene(ActionEvent)
     * @see javafx.stage.Window
     * @param event
     * @return Window of current controller.
     */
    public Window getWindow(ActionEvent event) {
        return this.getScene(event).getWindow();
    }

    /**
     * Gets stage by calling getWindow.
     *
     * @see GenericController#getWindow(ActionEvent)
     * @see javafx.stage.Stage
     * @param event
     * @return Stage of current controller.
     */
    public Stage getStage(ActionEvent event) {
        return (Stage) this.getWindow(event);
    }
}
