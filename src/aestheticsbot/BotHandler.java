package aestheticsbot;

import fonts.FontManager;
import java.util.ArrayList;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import utils.LocalisationService;

/**
 * handler class for incoming updates
 * @author Luke
 */
class BotHandler extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return Settings.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        
        //any command received
        if(update.hasMessage()){
            String command = update.getMessage().getText();
            
            if(command.equals("/start") || command.equals("start")){
                SendMessage msg = new SendMessage();
                msg.setReplyMarkup(new Keyboard());   //set keyboard
                msg.setText(LocalisationService.getInstance().getString("onStart"));
                msg.setChatId(update.getMessage().getChatId().toString());
                msg.enableMarkdown(true);
                
                try {
                    sendMessage(msg);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }
            
            if(command.equals("/help") || command.equals("help")){
                SendMessage msg = new SendMessage();
                msg.setText(LocalisationService.getInstance().getString("onHelp"));
                msg.setChatId(update.getMessage().getChatId().toString());
                msg.enableMarkdown(true);
                
                try {
                    sendMessage(msg);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }
            
            if(command.equals("How does this work?")){
                SendMessage msg = new SendMessage();
                msg.setText(LocalisationService.getInstance().getString("onHow"));
                msg.setChatId(update.getMessage().getChatId().toString());
                msg.enableMarkdown(true);
                
                try {
                    sendMessage(msg);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }
            
            if(command.equals("/about") || command.equals("about")){
                SendMessage msg = new SendMessage();
                msg.setText(LocalisationService.getInstance().getString("onAbout"));
                msg.setChatId(update.getMessage().getChatId().toString());
                msg.enableMarkdown(true);
                
                try {
                    sendMessage(msg);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }
        }
        
        //inline query received
        if(update.hasInlineQuery()){
            InlineQuery query = update.getInlineQuery();
            String text = query.getQuery();
            AnswerInlineQuery answer = new AnswerInlineQuery();
            answer.setInlineQueryId(query.getId());
            
            if(query.getQuery().isEmpty()){
                answer.setResults(new ArrayList<>());
            }else{
                FontManager manager = new FontManager(text);
                manager.populateResult();
                answer.setCacheTime(100);
                answer.setResults(manager.getInlineArray());
            }
            
            try {
                answerInlineQuery(answer);
            } catch (TelegramApiException ex) {
                ex.toString();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return Settings.BOT_USERNAME;
    }
    
}
