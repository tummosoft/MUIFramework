package com.tummosoft.MUI;

import anywheresoftware.b4a.BA.ShortName;

@ShortName("ViewBag")
public class ViewBag {
    public String viewPort = "";
    public String Title = "";
    public String MetaDescription = "";
    public String MetaKeywords = "";
    public String SiteName = "";
    public String RootDomain = "";
    public String ShortcutIcon = "";
    public String ImageURL = "";
    public String Url = "";
    public String TypeInfo = "";
    public String Robot = "";
    public String GeoRegion = "";
    public String GeoPosition ="";
    public String fbProfileID ="";
    public String Author ="";
    public String Copyright ="";
    public String [] Stylesheet = null;
    public String [] Script = null;
    public String [] CustomTag = null;
    public String [] CustomText = null;
    private StringBuilder rs = new StringBuilder();
    public boolean hasTwitterTag = false;    
    public boolean hasOpenGraph = false;    

    public String builder() {
        rs.append(viewPort);
        rs.append("<title>" + Title + "</title>");
        rs.append("<link rel='shortcut icon' href='" + ShortcutIcon + "'/>");
        rs.append("<meta name='description' content='" + MetaDescription + "'/>");                
        rs.append("<meta name='keywords' content='" + MetaKeywords + "'/>");       
        rs.append("<meta name='robots' content='" + Url + "'/>");
        rs.append("<meta name='geo.region' content='" + GeoRegion + "'/>");
        rs.append("<meta name='geo.position' content='" + GeoPosition + "'/>");
        rs.append("<meta name='ICBM' content='" + GeoPosition + "'/>");
        rs.append("<meta name='author' content='" + Author + "'/>");
        rs.append("<meta name='copyright' content='" + Copyright + "'/>");
        rs.append("<meta property='fb:profile_id' content='" + fbProfileID + "'/>");

        if (hasTwitterTag == true) {            
            rs.append("<meta property='og:type' content='" + TypeInfo + "'/>");
            rs.append("<meta property='og:site_name' content='" + SiteName + "'/>");
            rs.append("<meta property='og:title' content='" + Title + "'/>");
            rs.append("<meta property='og:description' content='" + MetaDescription + "'/>");
            rs.append("<meta property='og:url' content='" + Url + "'/>");
            rs.append("<meta property='og:image' itemprop='image primaryImageOfPage' content='" + ImageURL + "'/>");
        }
       
        if (hasTwitterTag == true) {
            rs.append("<meta name='twitter:card' content='summary_large_image'/>");  
            rs.append("<meta name='twitter:site' content='" + SiteName + "'/>");                
            rs.append("<meta name='twitter:title' content='" + Title + "'/>");       
            rs.append("<meta name='twitter:description' content='" + MetaDescription + "'/>");
            rs.append("<meta name='twitter:image' content='" + ImageURL + "'/>");
        }
        
        if (Stylesheet.length > 0) {
            for (String stylesheet : Stylesheet) {
                rs.append("<link rel='stylesheet' href='" + stylesheet + "'/>");    
            }            
        }

        if (CustomTag.length > 0) {
            for (String customtag : CustomTag) {
                rs.append(customtag);    
            }            
        }
        
        if (CustomText.length > 0) {
            for (String customtext : CustomText) {
                rs.append(customtext);    
            }            
        }

        if (Script.length > 0) {
            for (String script : Script) {
                rs.append("<script type='text/javascript' src='" + script + "'/>");    
            }            
        }

        rs.append("</head><body>");
        return rs.toString();
    }
}
