package com.example.factories;

import com.example.buttons.Button;
import com.example.buttons.MacButton;
import com.example.checkbox.Checkbox;
import com.example.checkbox.MacCheckbox;

/**
 * @author diviner16
 * @date 2023年09月30日 16:33
 */
public class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
