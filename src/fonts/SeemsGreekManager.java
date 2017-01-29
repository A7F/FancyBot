package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class SeemsGreekManager implements BotFunctions{
    public static final String GK_CHARS = "ΔβĆĐ€₣ǤĦƗĴҜŁΜŇØƤΩŘŞŦỮVŴЖ¥Ž";
    
    public String toGreek(String string){
        StringBuilder sb = new StringBuilder();
        char[] greekLow = GK_CHARS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(greekLow[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(greekLow[index-temp_uppercase-1]);
            }
            else if(index==32){
                sb.append(' ');
            }
            else{
                sb.append(tmp[i]);
            }
        }
        
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("SeemsGreek");
        article.setId("12");
        article.setDescription(toGreek(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toGreek(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
