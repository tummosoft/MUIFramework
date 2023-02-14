package com.tummosoft.MUI;

import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("HtmlControls")
public class HtmlControls {
    public String id = "";
    public String Text = "";
    public String ClassName = "";
    public String AttrName = "";
    public String Value = "";    
    public String Name = "";
    public String Label = "";
    public String Style = "";
    public boolean hasLineBreaks = false;    
    private String _type;
    public String form = "";
    public String Placeholder = "";
    public ControlEvents ControlEvent;
    public Map overrideEvent;
    
    public void Initialize(String type) {                
        _type = type.toLowerCase();
        ControlEvent = new ControlEvents(this);
        overrideEvent = new Map();
    }
    
    public String GetHTML() {
        String rs = "";
        String brk = "";
        String _id = id;
        String _name = Name;
        if (hasLineBreaks == true) {
            brk = "</br>";        
        }
        
        if (Style.length() > 0) {            
            Style = "style='" + Style + "' ";
        }
        if (ClassName.length() > 0) {            
            ClassName = "class='" + ClassName + "' ";
        }
        if (_id.length() > 0) {            
            _id = "id='" + _id + "' ";
        }
        if (Value.length() > 0) {            
            Value = "value='" + Value + "' ";
        }
        if (Label.length() > 0) {      
            Label = "<label for='" + Name + "'>" + Label + "</label>" + brk;
        }

        if (_name.length() > 0) {            
            _name = "name='" + _name + "' ";
        }
        if (Placeholder.length() > 0) {            
            Placeholder = "placeholder='" + Placeholder + "' ";
        }
        
        if (_type == "text") {          
            rs = rs + Label + "<input type='" +  _type + "' " + _id + ClassName + Style + AttrName + _name + Placeholder + Value + " /> \n" + brk;
        } else {
            
            rs = rs + "<" +  _type + " " + _id + ClassName + Style + AttrName + _name + Value + " >" + Text + "</" +  _type + ">" + brk +  "\n";
        }
                
        rs = rs.replaceAll("'", "\"");

        return rs + ControlEvent.getHTML();
    }

}
