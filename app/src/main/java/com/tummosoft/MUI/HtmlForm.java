package com.tummosoft.MUI;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

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
       
    public void Initialize(String event, HtmlControls[] elements) {        
        _elements = elements;                
        _event = event;
        formEvent = new FormEvents(this);
    }

    public String getEventName() {
        return _event;
    }

    public String getHTML() {
        String rs = "";
        String form = "";

        if (id != "") {
            id = "id='" + id + "' ";
        }

        if (className != "") {
            className = "class='" + className + "' ";
        }
        
        if (Name != "") {
            Name = "name='" + Name + "' ";
        }

        if (action != "") {
            action = "action='" +  action + "' ";
        }
        
        atrr = atrr + " ";

        String[] tem = formEvent.getHTML();

        form = "<form " + id + action + className + Name + atrr + tem[0] + "> \n";
        form = form.trim();
        for (int i=0; i < _elements.length; i++) {
            HtmlControls ele = _elements[i];
            rs = rs + "\n" + ele.GetHTML() + "\n";
        }
        rs = "\n" + form + rs + "</form> \n"  + tem[1];
        
        return rs;
    }

}
