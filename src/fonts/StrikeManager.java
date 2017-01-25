package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class StrikeManager implements BotFunctions{
    char spec = '̶';
    
    public String toStrikethrough(String string){
        StringBuilder sb = new StringBuilder();
        String[] tmp = string.split("");
        
        for(int i=0;i<tmp.length;i++){
            if(!tmp[i].equals(" ")){
                sb.append(tmp[i]).append(spec);
            }else{
                sb.append(tmp[i]);
            }
        }
        
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("Strikethrough");
        article.setId("4");
        article.setDescription(toStrikethrough(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toStrikethrough(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
