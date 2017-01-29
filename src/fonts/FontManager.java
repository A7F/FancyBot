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
        BlocksManager m0 = new BlocksManager();
        BubbleManager m1 = new BubbleManager();  
        FullwidthManager m2 = new FullwidthManager(); 
        SmallcapsManager m3 = new SmallcapsManager(); 
        StrikeManager m4 = new StrikeManager();
        TumblrManager m5 = new TumblrManager();
        UpdownManager m6 = new UpdownManager();
        WizardManager m7 = new WizardManager();
        ReverseHandler m8 = new ReverseHandler(); 
        SmallApexHandler m9 = new SmallApexHandler();
        MoreTumblrHandler m10 = new MoreTumblrHandler();
        OrientalHandler m11 = new OrientalHandler();
        SeemsGreekManager m12 = new SeemsGreekManager();
        CompressedManager m13 = new CompressedManager();
        BarManager m14 = new BarManager();
        
        inlineQueryResults.add(m2.getPreparedFont(queryText));
        inlineQueryResults.add(m4.getPreparedFont(queryText));
        inlineQueryResults.add(m3.getPreparedFont(queryText));
        inlineQueryResults.add(m1.getPreparedFont(queryText));
        inlineQueryResults.add(m6.getPreparedFont(queryText));
        inlineQueryResults.add(m7.getPreparedFont(queryText));
        inlineQueryResults.add(m5.getPreparedFont(queryText));
        inlineQueryResults.add(m0.getPreparedFont(queryText));
        inlineQueryResults.add(m9.getPreparedFont(queryText));
        inlineQueryResults.add(m8.getPreparedFont(queryText));
        inlineQueryResults.add(m10.getPreparedFont(queryText));
        inlineQueryResults.add(m11.getPreparedFont(queryText));
        inlineQueryResults.add(m12.getPreparedFont(queryText));
        inlineQueryResults.add(m13.getPreparedFont(queryText));
        inlineQueryResults.add(m14.getPreparedFont(queryText));
    }
    
    
    public void setQueryText(String text){
        this.queryText=text;
    }
    
    public List<InlineQueryResult> getInlineArray(){
        return this.inlineQueryResults;
    }
}
