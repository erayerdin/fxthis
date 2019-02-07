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

/**
 * <p>A View binds an <code>fxml</code> file and POJO together.</p>
 *
 * <p>Simply extend this class and definitely use <code>setViewFile</code> in constructor in order to define
 * what XML file you are going to use.</p>
 *
 * <p>There are many getters and setters to set properties of an <code>fxml</code> file. These are not
 * JavaFX beans and cannot be changed on the runtime, so you need to set these beforehand.</p>
 */
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

    public GenericView() {
        this.title = new SimpleStringProperty("JavaFX Application");
    }

    /**
     * @return A Scene based on this view.
     * @throws IOException
     */
    public Scene getScene() throws IOException {
        Scene scene = null;

        String viewFile = this.getViewFile();
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource(viewFile));

        if (this.width < 1 || this.height < 1)
            scene = new Scene(root);
        else
            scene = new Scene(root, this.width, this.height);

        return scene;
    }

    /**
     * @return A Stage based on this view.
     * @throws IOException
     */
    public Stage getStage() throws IOException {
        Stage stage = new Stage();

        if (this.getTitle() != null)
            stage.titleProperty().bindBidirectional(this.titleProperty());

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

    /**
     * @return The path of view file in classpath, including base directory.
     */
    public String getViewFile() {
        StringBuilder builder = new StringBuilder();
        builder.append(getBaseDir());
        builder.append('/');
        builder.append(this.viewFile);
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

    /**
     * @return Base directory for views in classpath.
     */
    public static String getBaseDir() {
        return baseDir;
    }

    /**
     * @param baseDir Base directory for views in classpath.
     */
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
