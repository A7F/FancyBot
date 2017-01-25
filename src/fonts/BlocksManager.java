package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class BlocksManager implements BotFunctions{
    public static final String BLOCKS_LOWER_CHARS = "【a】 【b】 【c】 【d】 【e】 【f】 【g】 【h】 【i】 【j】 【k】 【l】 【m】 【n】 【o】 【p】 【q】 【r】 【s】 【t】 【u】 【v】 【w】 【x】 【y】 【z】";
    public static final String BLOCKS_UPPER_CHARS = "【A】 【B】 【C】 【D】 【E】 【F】 【G】 【H】 【I】 【J】 【K】 【L】 【M】 【N】 【O】 【P】 【Q】 【R】 【S】 【T】 【U】 【V】 【W】 【X】 【Y】 【Z】";
    
    public String toBlocks(String string){
        StringBuilder sb = new StringBuilder();
        String[] blocksLow = BLOCKS_LOWER_CHARS.split(" ");
        String[] blocksHigh = BLOCKS_UPPER_CHARS.split(" ");
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(blocksLow[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(blocksHigh[index-temp_uppercase-1]);
            }
            else if(index==32){
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input){
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("BlackBlocks");
        article.setId("0");
        article.setDescription(toBlocks(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toBlocks(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
