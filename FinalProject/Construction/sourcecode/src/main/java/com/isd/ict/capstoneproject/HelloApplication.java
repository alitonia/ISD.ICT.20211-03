package com.isd.ict.capstoneproject;

import impl.org.controlsfx.ReflectionUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import com.isd.ict.capstoneproject.views.handler.ViewsConfigs;
import com.isd.ict.capstoneproject.utils.Utils;
import com.isd.ict.capstoneproject.views.handler.home.HomeScreenHandler;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * do not refactor this method without discussion
 * require some reconfiguration in pom
 */
public class HelloApplication extends Application {

    private static final Logger LOGGER = Utils.getLogger(HelloApplication.class.getName());

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            var x = new ViewsConfigs();

            var fs = ViewsConfigs.class.getDeclaredFields();
            var fieldToAsset = new HashMap<String, URL>();

            for (var field : fs) {
                var localAssetsStr = field.get(x).toString();
                var url = this.getClass().getResource(localAssetsStr);
                fieldToAsset.put(localAssetsStr, url);
            }
            Utils.sideLoader(fieldToAsset);

            // initialize the scene
            StackPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ViewsConfigs.SPLASH_SCREEN_PATH)));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            // fade in effect
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            // fade out effect
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), root);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();
            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            // After fade out, load actual content
            fadeOut.setOnFinished((e) -> {
                try {
                    HomeScreenHandler homeScreenHandler = new HomeScreenHandler(primaryStage, ViewsConfigs.HOME_DOCK_LIST_SCREEN_PATH);
                    homeScreenHandler.getPath();
                    homeScreenHandler.setHomeScreenHandler(homeScreenHandler);
                    homeScreenHandler.setPreviousScreen(homeScreenHandler);
                    homeScreenHandler.setScreenTitle("Home");
                    homeScreenHandler.show();
                } catch (IOException ex) {
                    LOGGER.info(ex.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}
