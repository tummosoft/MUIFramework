package com.tummosoft.MUI;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@Version(1.0f)
@ShortName("HtmlHelper")
public class HtmlHelper {
    StringBuilder _htmlcode = new StringBuilder();
    public String [] customscript = null;

    public void Initialize(String languageTag, ViewBag viewbag) {
        String rs = """
        <!DOCTYPE html>
        <html lang='%s'>
        <head>
        <meta charset='utf-8'>        
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />       
        """;
        String s = String.format(rs, languageTag);
        _htmlcode.append(s);
        _htmlcode.append(viewbag.builder());
    }

    

    public String builder() {
        if (customscript.length > 0) {
            for (String scr : customscript) {
                _htmlcode.append(scr);
            }    
        }
        _htmlcode.append("</body></html>");
        return _htmlcode.toString();
    }

}   
