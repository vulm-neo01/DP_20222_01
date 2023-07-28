package views.screen.handleError;

import views.screen.textError.TextErrorScreen;

public class HandleTextError implements HandleErrorStrategy{

    @Override
    public void handelError(String messageError) {
        try {
            TextErrorScreen.error(messageError);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
