package views.screen.handleError;

import views.screen.popup.PopupScreen;

public class HandlePopupError implements HandleErrorStrategy {
    @Override
    public void handelError(String messageError) {
        try {
            PopupScreen.error(messageError);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
