package fxthis.views;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AnyView extends GenericView {
    public AnyView() {
        this.setViewFile("ExampleScene.fxml");
        this.setTitle("Demo Application");
        this.setResizable(false);
        this.setHeight(500);
    }
}

@ExtendWith(ApplicationExtension.class)
class GenericViewTest {
    GenericView view;

    @Start
    private void start(Stage stage) throws IOException {
        view = new AnyView();
        stage = view.getStage();
        stage.show();
    }

    @Test
    void getScene() throws IOException {
        view.getScene();
    }

    @Test
    void getTitle() {
        assertEquals("Demo Application",  view.getTitle());
    }

    @Test
    void getIcon() {
        assertNull(view.getIcon());
    }

    @Test
    void getWidth() {
        assertEquals(0, view.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(500, view.getHeight());
    }

    @Test
    void isDecorated() {
        assertTrue(view.isDecorated());
    }

    @Test
    void isResizable() {
        assertFalse(view.isResizable());
    }

    @Test
    void isModal() {
        assertFalse(view.isModal());
    }

    @Test
    void isMaximized() {
        assertFalse(view.isMaximized());
    }

    @Test
    void isFullscreen() {
        assertFalse(view.isFullscreen());
    }

    @Test
    void getGlobalIcon() {
        assertNull(GenericView.getGlobalIcon());
    }
}