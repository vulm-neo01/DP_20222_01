package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import entity.payment.ConcreteStategy.Card;
import entity.payment.ConcreteStategy.Cash;
import entity.payment.ConcreteStategy.EWallet;
import entity.payment.ConcreteStategy.PaymentStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class PaymentScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ComboBox chosingPayment;

	@FXML
	private ImageView loadingImage;

	private Invoice invoice;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField holderName;

	@FXML
	private TextField name;
	@FXML
	private TextField address;
	@FXML
	private TextField phonenumber;
	@FXML
	private TextField walletId;
	@FXML
	private TextField code;

	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;

	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
			setupData(invoice);
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error(ex.getMessage());
		}
	}

	protected void setupData(Object dto) throws Exception {
		this.invoice = (Invoice) dto;
	}

	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

	void confirmToPayOrder() throws IOException{
		PaymentStrategy ctrl = null;
		String contents = "pay order";
		if(chosingPayment.equals("Credit Card")){
			ctrl = new Card(invoice.getAmount(), contents, cardNumber.getText(),holderName.getText(),expirationDate.getText(),Integer.parseInt(securityCode.getText()));

		} else if(chosingPayment.equals("Cash")){
			ctrl = new Cash(invoice.getAmount(), contents, name.getText(), address.getText(), phonenumber.getText());

		} else if(chosingPayment.equals("EWallet")){
			ctrl = new EWallet(invoice.getAmount(), contents, walletId.getText(), code.getText());
		}

		Map<String, String> response = ctrl.order();
		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}
}