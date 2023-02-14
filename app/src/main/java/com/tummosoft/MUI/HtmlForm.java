package com.tummosoft.MUI;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.*;

@ShortName("HtmlForm")
public class HtmlForm {
    HtmlControls[] _elements;
    public FormEvents formEvent;       
    String _event = "";
    public String action = "";
    public String id = "";
    public String className = "";
    public String Name = "";
    public String atrr = "";
    public Map OverrideEvent;
       
    public void Initialize(String event, HtmlControls[] elements) {        
        _elements = elements;                
        _event = event;        
        formEvent = new FormEvents(this, OverrideEvent);
              
    }
    
    public String getHTML() {
        String rs = "";
        String form = "";
        String _id = id;
        String _name = Name;

        if (_id != "") {
            _id = "id='" + _id + "' ";
        }

        if (className != "") {
            className = "class='" + className + "' ";
        }
        
        if (_name != "") {
            _name = "name='" + _name + "' ";
        }

        if (action != "") {
            action = "action='" +  action + "' ";
        }
        
        atrr = atrr + " ";
        
        form = "<form " + _id + action + className + _name + atrr + "> \n";
        form = form.trim();
        for (int i=0; i < _elements.length; i++) {
            HtmlControls ele = _elements[i];
            rs = rs + "\n" + ele.GetHTML() + "\n";
        }
        rs = "\n" + form + rs + "</form> \n"  + formEvent.getHTML();
        
        return rs;
    }

}
