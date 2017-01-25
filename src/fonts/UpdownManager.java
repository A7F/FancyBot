package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class UpdownManager implements BotFunctions{

    public String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
    public String split = "ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,"+"∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ"+"0ƖᄅƐㄣϛ9ㄥ86";
    
    public String toUpside(String string){
        String newstr = "";
        char letter;
        for (int i = 0;i< string.length();i++) {
            letter = string.charAt(i);
            int a = normal.indexOf(letter);
            newstr += (a != -1) ? split.charAt(a) : letter;
        }
        return new StringBuilder(newstr).reverse().toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("UpsideDown");
        article.setId("6");
        article.setDescription(toUpside(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toUpside(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
