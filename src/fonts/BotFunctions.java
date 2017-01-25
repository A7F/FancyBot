package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luca
 */
public interface BotFunctions {
    public InlineQueryResultArticle getPreparedFont(String input);
}
