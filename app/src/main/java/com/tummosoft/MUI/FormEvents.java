package com.tummosoft.MUI;

import anywheresoftware.b4a.objects.collections.*;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("FormEvents")
public class FormEvents {
    public Boolean onblur = false;	//script	Fires the moment that the element loses focus
    public Boolean onchange = false;	//script	Fires the moment when the value of the element is changed
    public Boolean oncontextmenu = false; //	script	Script to be run when a context menu is triggered
    public Boolean onfocus = false;	//script	//Fires the moment when the element gets focus
    public Boolean oninput = false;	//script	//Script to be run when an element gets user input
    public Boolean oninvalid = false;	//script	Script to be run when an element is invalid
    public Boolean onreset = false;	//script	Fires when the Reset button in a form is clicked
    public Boolean onsearch = false; //	script	Fires when the user writes something in a search field (for <input="search">)
    public Boolean onselect = false;	//script	Fires after some text has been selected in an element
    public Boolean onsubmit = false;	
    HtmlForm _hmtlForm;
    public Map overrideEvent;

    public FormEvents() {
       
    }

    public FormEvents(HtmlForm hmtlForm, Map customEvent) {
        _hmtlForm = hmtlForm;         
        overrideEvent = new Map();
    }

    public String getHTML() {    
        String event = "";
        String script = "";
        String ev =  _hmtlForm.id;
        StringBuilder build = new StringBuilder();
        String temp = "";
        Map customEvent = _hmtlForm.OverrideEvent;
        if (onblur == true) {            
            temp = "$('#" + ev + "').blur(function(event) {  \n"
                + customEvent.Get("onblur") + "\n"                
                + "});\n ";

            build.append(temp);
        }

                        
        String script_event = "<script> \n"
        + build.toString() + "\n"
        + "</script> \n";
        
        
        return script_event;
    }
}
