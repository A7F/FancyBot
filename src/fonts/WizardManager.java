package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class WizardManager implements BotFunctions{
    public static final String WIZARD_CHARS = "ค๒ς๔єŦﻮђเןкl๓ภ๏קợгรtยשฬץאz";
    
    public String toWizard(String string){
        StringBuilder sb = new StringBuilder();
        char[] wizardcaps = WIZARD_CHARS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(wizardcaps[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(wizardcaps[index-temp_uppercase-1]);
            }
            else if(index==32){
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("Wizard");
        article.setId("7");
        article.setDescription(toWizard(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toWizard(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}
