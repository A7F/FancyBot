package fonts;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResult;

/**
 * class to handle all other fonts. Build InlineQueryResult ArrayList to prepare inline query response.
 * @author Luke
 */
public class FontManager {
    
    private List<InlineQueryResult> inlineQueryResults = new ArrayList<>();
    private String queryText;
    
    public FontManager(){};
    
    public FontManager(String text){
        this.queryText=text;
    }
    
    public void populateResult(){
        FullwidthManager fwd = new FullwidthManager();
        StrikeManager sm = new StrikeManager();
        SmallcapsManager smm = new SmallcapsManager();
        BubbleManager bmgr = new BubbleManager();
        UpdownManager udmgr = new UpdownManager();
        WizardManager wmgr = new WizardManager();
        TumblrManager tmgr = new TumblrManager();
        BlocksManager blmgr = new BlocksManager();
        
        inlineQueryResults.add(fwd.getPreparedFont(queryText));
        inlineQueryResults.add(sm.getPreparedFont(queryText));
        inlineQueryResults.add(smm.getPreparedFont(queryText));
        inlineQueryResults.add(bmgr.getPreparedFont(queryText));
        inlineQueryResults.add(udmgr.getPreparedFont(queryText));
        inlineQueryResults.add(wmgr.getPreparedFont(queryText));
        inlineQueryResults.add(tmgr.getPreparedFont(queryText));
        inlineQueryResults.add(blmgr.getPreparedFont(queryText));
    }
    
    
    public void setQueryText(String text){
        this.queryText=text;
    }
    
    public List<InlineQueryResult> getInlineArray(){
        return this.inlineQueryResults;
    }
}
