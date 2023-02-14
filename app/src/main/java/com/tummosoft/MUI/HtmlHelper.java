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
    StringBuilder _htmlcode;
    StringBuilder _body;
    String _ws = "";
    
           
    public void Initialize(BA ba, String event, String ws) {        
        _htmlcode = new StringBuilder();
        _body = new StringBuilder();
        _ws = ws;
        
    }

    public String builder(ViewBag _viewbag) {
        
        String _head = viewbagBuilder(_viewbag);
        _htmlcode.append(_head);
        _htmlcode.append(_body);
        _htmlcode.append("</body></html>");
        return _htmlcode.toString();
    }

    public void addBody(String html) {
        _body.append(html);
    }

    private String viewbagBuilder(ViewBag _viewbag) {
        StringBuilder rs = new StringBuilder();
       
        String head = "<!DOCTYPE html> \n"
        + "<html lang='" + _viewbag.Language + "'> \n"
        + "<head> \n"
        + "<meta charset='utf-8'> \n"        
        + "<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'> \n"
        + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
        
        rs.append(head).append("\n");;

        rs.append(_viewbag.viewPort).append("\n");;
        rs.append("<title>" + _viewbag.Title + "</title>").append("\n");
        rs.append("<link rel='shortcut icon' href='" + _viewbag.ShortcutIcon + "'/>").append("\n");
        rs.append("<meta name='description' content='" + _viewbag.MetaDescription + "'/>").append("\n");               
        rs.append("<meta name='keywords' content='" + _viewbag.MetaKeywords + "'/>").append("\n");      
        rs.append("<meta name='robots' content='" + _viewbag.Url + "'/>").append("\n");
        rs.append("<meta name='geo.region' content='" + _viewbag.GeoRegion + "'/>").append("\n");
        rs.append("<meta name='geo.position' content='" + _viewbag.GeoPosition + "'/>").append("\n");
        rs.append("<meta name='ICBM' content='" + _viewbag.GeoPosition + "'/>").append("\n");
        rs.append("<meta name='author' content='" + _viewbag.Author + "'/>").append("\n");
        rs.append("<meta name='copyright' content='" + _viewbag.Copyright + "'/>").append("\n");
        rs.append("<meta property='fb:profile_id' content='" + _viewbag.fbProfileID + "'/>").append("\n");

        if (_viewbag.hasTwitterTag == true) {            
            rs.append("<meta property='og:type' content='" + _viewbag.TypeInfo + "'/>").append("\n");
            rs.append("<meta property='og:site_name' content='" + _viewbag.SiteName + "'/>").append("\n");
            rs.append("<meta property='og:title' content='" + _viewbag.Title + "'/>").append("\n");
            rs.append("<meta property='og:description' content='" + _viewbag.MetaDescription + "'/>").append("\n");
            rs.append("<meta property='og:url' content='" + _viewbag.Url + "'/>").append("\n");
            rs.append("<meta property='og:image' itemprop='image primaryImageOfPage' content='" + _viewbag.ImageURL + "'/>").append("\n");
        }
       
        if (_viewbag.hasTwitterTag == true) {
            rs.append("<meta name='twitter:card' content='summary_large_image'/>").append("\n");
            rs.append("<meta name='twitter:site' content='" + _viewbag.SiteName + "'/>").append("\n");               
            rs.append("<meta name='twitter:title' content='" + _viewbag.Title + "'/>").append("\n");      
            rs.append("<meta name='twitter:description' content='" + _viewbag.MetaDescription + "'/>").append("\n");
            rs.append("<meta name='twitter:image' content='" + _viewbag.ImageURL + "'/>").append("\n");
        }
        
        if (_viewbag.Stylesheet.length > 0) {
            for (String stylesheet : _viewbag.Stylesheet) {
                rs.append("<link rel='stylesheet' href='" + stylesheet + "'/>").append("\n");   
            }            
        }

        if (_viewbag.CustomTag.length > 0) {
            for (String customtag : _viewbag.CustomTag) {
                rs.append(customtag).append("\n");   
            }            
        }
        
        if (_viewbag.CustomText.length > 0) {
            for (String customtext : _viewbag.CustomText) {
                rs.append(customtext).append("\n");  
            }            
        }

        if (_viewbag.Script.length > 0) {
            for (String script : _viewbag.Script) {
                rs.append("<script type='text/javascript' src='" + script + "'/>").append("\n");   
            }            
        }

        if (_ws.length() > 0) {
           
            rs.append("<script>").append("\n");   
            rs.append("$(document).ready(function() {").append("\n");   
            rs.append("b4j_connect('" + _ws + "');").append("\n");   
            rs.append("});").append("\n");   
            rs.append("</script>").append("\n");   
        }

        rs.append("</head><body>");
        return rs.toString();
    }
}   
