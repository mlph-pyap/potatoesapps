package com.monstarlabsph.potatoesandroid.ui.elements.core.spinnerbutton;

import android.widget.NumberPicker;

public class NumberPickerData {

    private final NumberPicker numberPicker;
    private final String[] valueArray;

    public NumberPickerData(NumberPicker numberPicker,String[] valueArray) {
        this.numberPicker = numberPicker;
        this.valueArray = valueArray;
    }

    public NumberPicker getNumberPicker(){
        return this.numberPicker;
    }
    public String[] getValueArray(){
        return this.valueArray;
    }
}
