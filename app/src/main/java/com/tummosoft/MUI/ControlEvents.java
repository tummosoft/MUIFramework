package com.tummosoft.MUI;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.collections.Map;

public class ControlEvents {
    public Boolean onkeydown = false;	//script	Fires the moment that the element loses focus
    public Boolean onkeypress = false;	//script	Fires the moment when the value of the element is changed
    public Boolean onkeyup = false; //	script	Script to be run when a context menu is triggered
    
    public Boolean onclick  = false;
    public Boolean ondblclick = false;
    public Boolean onmousedown = false;
    public Boolean onmousemove = false;
    public Boolean onmouseout = false;
    public Boolean onmouseover = false;
    public Boolean onmouseup = false;
    public Boolean onmousewheel = false;
    public Boolean onwheel = false;
    
    public Boolean ondrag = false;
    public Boolean ondragend = false;
    public Boolean ondragenter = false;
    public Boolean ondragleave = false;
    public Boolean ondragover = false;
    public Boolean ondragstart = false;
    public Boolean ondrop = false;
    public Boolean onscroll = false;
    
    HtmlControls _hmtlControl;

    public ControlEvents() {
       
    }

    public ControlEvents(HtmlControls hmtlcontrol) {
        _hmtlControl = hmtlcontrol;
    }

    public String getHTML() {            
        String event = "";
        String script = "";
        String ev = _hmtlControl.id;
        StringBuilder build = new StringBuilder();
        String temp = "";
        Map customEvent = _hmtlControl.overrideEvent;
        if (onkeydown == true) {            
            temp = "$('#" + ev + "').keydown(function(event) {  \n"
                + customEvent.Get("onkeydown") + "\n"                
                + "});\n ";

            build.append(temp);
        }

        if (onkeypress == true) {            
            temp = "$('#" + ev + "').keypress(function(event) {  \n"
                + customEvent.Get("onkeypress") + "\n"                
                + "}); \n";
            build.append(temp);
        
        }
                
        String script_event = "<script>"
        + build.toString()
        + "</script> \n";
        
        
        return script_event;
    }
}
