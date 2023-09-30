package com.example.factories;

import com.example.buttons.Button;
import com.example.buttons.WindowsButton;
import com.example.checkbox.Checkbox;
import com.example.checkbox.WindowsCheckbox;

/**
 * @author diviner16
 * @date 2023年09月30日 16:33
 */
public class windowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
