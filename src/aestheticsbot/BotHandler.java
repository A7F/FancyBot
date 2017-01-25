package aestheticsbot;

import fonts.FontManager;
import java.util.ArrayList;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

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
