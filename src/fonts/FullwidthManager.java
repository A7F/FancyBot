package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class FullwidthManager implements BotFunctions{
    public static final String FULL_WIDTH_UPPER_CHARS = "﻿ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
    public static final String FULL_WIDTH_LOWER_CHARS = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
    public static final String FULL_WIDTH_INTEGERS = "０１２３４５６７８９";
    
    public String toFullwidth(String string){
        StringBuilder sb = new StringBuilder();
        char[] result = string.toCharArray();
        for(int i=0;i<result.length;i++){
            char tmp = result[i];
            if(tmp != ' '){
                tmp = (char) (tmp+0xFEE0);
                sb.append(tmp);
            }else{
                sb.append(tmp);
            }
            
        }
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("Fullwidth");
        article.setId("2");
        article.setDescription(toFullwidth(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toFullwidth(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
