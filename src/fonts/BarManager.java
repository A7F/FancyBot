package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class BarManager implements BotFunctions{
    public static final String BAR_CHARS = "₳฿₵ĐɆ₣₲ⱧłJ₭Ⱡ₥₦Ø₱QⱤ₴₮ɄV₩ӾɎⱫ";
    
    public String toBars(String string){
        StringBuilder sb = new StringBuilder();
        char[] barsLow = BAR_CHARS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(barsLow[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(barsLow[index-temp_uppercase-1]);
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
        
        article.setTitle("Bars");
        article.setId("14");
        article.setDescription(toBars(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toBars(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
