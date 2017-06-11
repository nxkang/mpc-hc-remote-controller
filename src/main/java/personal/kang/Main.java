package personal.kang;

import com.eeeeeric.mpc.hc.api.FileInfo;
import com.eeeeeric.mpc.hc.api.MediaPlayerClassicHomeCinema;
import com.eeeeeric.mpc.hc.api.TimeCode;
import com.eeeeeric.mpc.hc.api.TimeCodeException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.kang.view.MainWindowViewModel;

import java.io.IOException;
import java.util.List;

/**
 * Created by kang on 2017/6/9.
 */
public class Main extends Application {

    Logger LOGGER = LoggerFactory.getLogger(Main.class);


    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Hello World");

        primaryStage.setOnCloseRequest(x -> ctx.close());

        this.showMainView();
    }


    public void showMainView() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/MainWindowView.fxml"));
            Parent root = loader.load();

            MainWindowViewModel vm = loader.getController();
            LocalMpcObserver localMpcObserver = ctx.getBean(LocalMpcObserver.class);
            localMpcObserver.addObserver(vm);

            RemoteMpcObserver remoteMpcObserver = ctx.getBean(RemoteMpcObserver.class);
            remoteMpcObserver.addObserver(vm);

            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();

        } catch (IOException e) {

            LOGGER.error(e.getMessage(), e);
        }
    }

    static ClassPathXmlApplicationContext ctx;

    public static void main(String[] args) {

        ctx = new ClassPathXmlApplicationContext(new String[]{
                "classpath:META-INF/spring/app-context.xml",
                "classpath:META-INF/spring/integration/jms.xml",
                "classpath:META-INF/spring/integration/spring-int-jms-client.xml",
                "classpath:META-INF/spring/integration/spring-int-jms-service.xml",
        });
        ctx.start();

        launch(args);
    }
}
