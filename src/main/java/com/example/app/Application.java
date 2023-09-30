package com.example.app;

import com.example.buttons.Button;
import com.example.checkbox.Checkbox;
import com.example.factories.GUIFactory;

/**
 * @author diviner16
 * @date 2023年09月30日 16:35
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application (GUIFactory guiFactory){
        button= guiFactory.createButton();
        checkbox= guiFactory.createCheckbox();
    }
    public void paint(){
        button.paint();
        checkbox.paint();
    }

}
