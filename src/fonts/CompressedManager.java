package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class CompressedManager implements BotFunctions{
    public static final String COMPR_CHARS = "ΔҌﾧdﾼԲɢￃΙۆӃﾤϺﾢﾷϸϘЯଌȚȗѵ￦ҲעŻ";
    
    public String toCompressed(String string){
        StringBuilder sb = new StringBuilder();
        char[] compressedLow = COMPR_CHARS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(compressedLow[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(compressedLow[index-temp_uppercase-1]);
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
        
        article.setTitle("Compressed");
        article.setId("13");
        article.setDescription(toCompressed(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toCompressed(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
