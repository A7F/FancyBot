package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class ReverseHandler implements BotFunctions{
    
    public String toReverse(String input){
        StringBuilder sb = new StringBuilder(input).reverse();
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("Reverse");
        article.setId("8");
        article.setDescription(toReverse(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toReverse(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
    
}
