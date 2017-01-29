package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class OrientalHandler implements BotFunctions{
    public static final String ORIENTAL_CHARS = "丹乃匚刀モ下ム卄工ＪＫㄥ爪れ口ㄗＱ尺ち匕∪∨山メㄚ乙";
    public static final String ORIENTAL_NUMBERS = "0|23456ヲȣ੧";
    
    public String toOriental(String string){
        StringBuilder sb = new StringBuilder();
        char[] orientalchars = ORIENTAL_CHARS.toCharArray();
        char[] numbers = ORIENTAL_NUMBERS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            int temp_number = 47;
            
            if(index<=122 && index>=97){
                sb.append(orientalchars[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(orientalchars[index-temp_uppercase-1]);
            }
            else if(index<=57 && index>=48){
                sb.append(numbers[index-temp_number-1]);
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
        
        article.setTitle("Asia");
        article.setId("11");
        article.setDescription(toOriental(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toOriental(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
