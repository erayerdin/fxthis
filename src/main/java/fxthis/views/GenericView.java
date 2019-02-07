package fxthis.views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

// todo 2 - class doc
public abstract class GenericView {
    private static String baseDir = "views";
    private static Image globalIcon = null;

    private String viewFile;
    private StringProperty title;
    private Image icon = null;
    private int width = 0;
    private int height = 0;
    private boolean decorated = true;
    private boolean resizable = true;
    private boolean modal = false;
    private boolean maximized = false;
    private boolean fullscreen = false;

    private Scene scene;
    private Stage stage;

    public GenericView() {
        this.title = new SimpleStringProperty("JavaFX Application");
    }

    // todo 2 - method doc
    public Scene getScene() throws IOException {
        if (scene != null)
            return this.scene;

        Scene scene = null;

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource(this.getViewFile()));

        if (this.width < 1 || this.height < 1)
            scene = new Scene(root);
        else
            scene = new Scene(root, this.width, this.height);

        this.scene = scene;

        return scene;
    }

    // todo 2 - method doc
    public Stage getStage() throws IOException {
        Stage stage = new Stage();

        if (this.getTitle() != null) stage.setTitle(this.getTitle());

        stage.setScene(this.getScene());

        stage.setResizable(this.isResizable());
        stage.setMaximized(this.isMaximized());
        stage.setFullScreen(this.isFullscreen());
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        if (!this.isDecorated()) stage.initStyle(StageStyle.UNDECORATED);
        if (this.isModal()) stage.initModality(Modality.APPLICATION_MODAL);

        if (this.getIcon() != null)
            stage.getIcons().add(this.getIcon());

        if (this.getIcon() == null && GenericView.getGlobalIcon() != null)
            stage.getIcons().add(GenericView.getGlobalIcon());

        return stage;
    }

    public String getViewFile() {
        StringBuilder builder = new StringBuilder();
        builder.append(getBaseDir());
        builder.append('/');
        builder.append(this.getViewFile());
        return builder.toString();
    }

    public void setViewFile(String viewFile) {
        this.viewFile = viewFile;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDecorated() {
        return decorated;
    }

    public void setDecorated(boolean decorated) {
        this.decorated = decorated;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized = maximized;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public static String getBaseDir() {
        return baseDir;
    }

    public static void setBaseDir(String baseDir) {
        GenericView.baseDir = baseDir;
    }

    public static Image getGlobalIcon() {
        return globalIcon;
    }

    public static void setGlobalIcon(Image globalIcon) {
        GenericView.globalIcon = globalIcon;
    }
}
