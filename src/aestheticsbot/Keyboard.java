package aestheticsbot;

import java.util.ArrayList;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 *
 * @author Luke
 */
public class Keyboard extends ReplyKeyboardMarkup{
    
    public Keyboard(){
        this.setOneTimeKeyboad(Boolean.TRUE);
        this.setResizeKeyboard(Boolean.TRUE);
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add("help");
        firstRow.add("about");
        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add("How does this work?");
        
        keyboard.add(firstRow);
        keyboard.add(secondRow);
        this.setKeyboard(keyboard);
    }
}
