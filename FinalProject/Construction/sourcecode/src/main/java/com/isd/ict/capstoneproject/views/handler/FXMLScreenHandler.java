package com.isd.ict.capstoneproject.views.handler;

import com.isd.ict.capstoneproject.utils.Utils;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * The {@link FXMLScreenHandler fxmlScreenHandler}
 * class handle common action on each screen.
 *
 */
public class FXMLScreenHandler {
    /**
     * loader
     */
    protected FXMLLoader loader;
    /**
     * content
     */
    protected BorderPane content;

    public FXMLScreenHandler() {
    }

    public FXMLScreenHandler(String screenPath) throws IOException {

        this.loader = new FXMLLoader(Objects.requireNonNull(Utils.getFXML(screenPath)));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = loader.load();
    }

    public FXMLScreenHandler(URL screenURL) throws IOException {
    // do not load assets in here. Very buggy in modular form
        this.loader = new FXMLLoader(screenURL);
        // Set this class as the controller
        this.loader.setController(this);
        this.content = loader.load();
    }

    /**
     * Get content
     *
     * @return {@link BorderPane borderPane}
     */
    public BorderPane getContent() {
        return this.content;
    }

    /**
     * Get loader
     *
     * @return {@link FXMLLoader fxmlLoader}
     */
    public FXMLLoader getLoader() {
        return this.loader;
    }

    /**
     * Set image
     *
     * @param imv
     * @param path
     */
    public void setImage(ImageView imv, String path) {
        File file = new File(path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }
}
