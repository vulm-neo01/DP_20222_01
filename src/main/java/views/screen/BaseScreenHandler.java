package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.logging.Logger;

import controller.AuthenticationController;
import controller.BaseController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.handleError.HandleErrorStrategy;
import views.screen.home.HomeScreenHandler;
import views.screen.popup.PopupScreen;
import views.screen.textError.TextErrorScreen;

public abstract class BaseScreenHandler extends FXMLScreenHandler {

	private HandleErrorStrategy handleError;
	private static final Logger LOGGER = Utils.getLogger(BaseScreenHandler.class.getName());

	public static final String errorLoading = "Error when loading resources.";
	public static final String notAnythingPlace = "You don't have anything to place";
	public static final String errorLogin = "Cant trigger Login";

	private Scene scene;
	private BaseScreenHandler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;

	protected BaseScreenHandler(Stage stage, String screenPath) throws IOException {
		super(screenPath);
		this.stage = stage;
	}

	public void setPreviousScreen(BaseScreenHandler prev) {
		this.prev = prev;
	}

	public BaseScreenHandler getPreviousScreen() {
		return this.prev;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

	public void setHandleError(HandleErrorStrategy handleError){
		this.handleError = handleError;
	}
	public void handleErrorScreen(String messageError){
		handleError.handelError(messageError);
	}
}
