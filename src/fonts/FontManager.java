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
        FullwidthManager fwd = new FullwidthManager();  //2
        StrikeManager sm = new StrikeManager(); //4
        SmallcapsManager smm = new SmallcapsManager();  //3
        BubbleManager bmgr = new BubbleManager();   //1
        UpdownManager udmgr = new UpdownManager();  //6
        WizardManager wmgr = new WizardManager();   //7
        TumblrManager tmgr = new TumblrManager();   //5
        BlocksManager blmgr = new BlocksManager();  //0
        
        ReverseHandler rh = new ReverseHandler();   //8
        SmallApexHandler smh = new SmallApexHandler();  //9
        MoreTumblrHandler mth = new MoreTumblrHandler();    //10
        OrientalHandler orh = new OrientalHandler();    //11
        
        inlineQueryResults.add(fwd.getPreparedFont(queryText));
        inlineQueryResults.add(sm.getPreparedFont(queryText));
        inlineQueryResults.add(smm.getPreparedFont(queryText));
        inlineQueryResults.add(bmgr.getPreparedFont(queryText));
        inlineQueryResults.add(udmgr.getPreparedFont(queryText));
        inlineQueryResults.add(wmgr.getPreparedFont(queryText));
        inlineQueryResults.add(tmgr.getPreparedFont(queryText));
        inlineQueryResults.add(blmgr.getPreparedFont(queryText));
        
        inlineQueryResults.add(smh.getPreparedFont(queryText));
        inlineQueryResults.add(rh.getPreparedFont(queryText));
        inlineQueryResults.add(mth.getPreparedFont(queryText));
        inlineQueryResults.add(orh.getPreparedFont(queryText));
    }
    
    
    public void setQueryText(String text){
        this.queryText=text;
    }
    
    public List<InlineQueryResult> getInlineArray(){
        return this.inlineQueryResults;
    }
}
