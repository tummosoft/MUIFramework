package com.tummosoft.MUI;

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

    public FormEvents() {
       
    }

    public FormEvents(HtmlForm hmtlForm) {
        _hmtlForm = hmtlForm;
    }

    public String[] getHTML() {    
        String [] rs = new String [2];  
        String event = "";
        String script = "";
        String eventname = _hmtlForm.getEventName();
        StringBuilder build = new StringBuilder();
        String temp = "";

        if (onblur == true) {            
            script = eventname + "_onblur(this)";
            event = event + " onblur='" + script + "'";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (onchange == true) {             
             script = eventname + "_onchange(this)";
             event = event + " onchange='" + script + "'";
             String ev = script.substring(0, script.length() - 6);
             temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (oncontextmenu == true) {
            script = eventname + "_oncontextmenu(this)";
            event =  event + " oncontextmenu='" + script + "'";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
            
        }
        if (onfocus == true) {            
            script = eventname + "_onfocus(this)";
            event = event + " onfocus='" + script + "'";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (oninvalid == true) {
             
             script = eventname + "_oninvalid(this)";
             event = event + " oninvalid='" + script + "'";
             String ev = script.substring(0, script.length() - 6);
             temp = "function " + ev + "(e) { \n"
             + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
             + "} \n";
             build.append(temp);
             BA.Log(ev + "(res as map)");
        }
        if (onreset == true) {            
            script = eventname + "_onreset(this)";
            event = event + " onreset='";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (onsearch == true) {
            
            script = eventname + "_onsearch(this)";
            event = event + " onsearch='" + script + "'";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (onselect == true) {
            
            script = eventname + "_onselect(this)";
            event = event + " onselect='" + script + "'";
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        }
        if (onsubmit == true) {            
            script = eventname + "_onsubmit(this)";
            BA.Log("");
            event = event + " onsubmit='" + script + "'";	
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        } 
        
        if (oninput == true) {            
            script = eventname + "_oninput(this)";
            BA.Log("");
            event = event + " oninput='" + script + "'";	
            String ev = script.substring(0, script.length() - 6);
            temp = "function " + ev + "(e) { \n"
            + "b4j_raiseEvent('" + ev + "', {id:14}) \n"
            + "} \n";
            build.append(temp);
            BA.Log(ev + "(res as map)");
        } 

        
        String script_event = "<script>"
        + build.toString()
        + "</script> \n";

        rs[0] = event;
        rs[1] = script_event;
        
        
        return rs;
    }
}
