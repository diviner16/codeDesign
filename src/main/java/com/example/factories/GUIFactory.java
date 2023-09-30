package com.example.factories;

import com.example.buttons.Button;
import com.example.checkbox.Checkbox;

/**
 * @author diviner16
 * @date 2023年09月30日 16:32
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
