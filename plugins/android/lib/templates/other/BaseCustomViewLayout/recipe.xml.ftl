<?xml version="1.0"?>
<recipe>
			 
    <instantiate from="root/res/values/sample.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(viewName)}.xml" />

    <instantiate from="root/src/app_package/CustomView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}.java" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(viewName)}.xml" />
</recipe>
