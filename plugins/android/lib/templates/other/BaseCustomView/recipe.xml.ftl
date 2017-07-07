<?xml version="1.0"?>
<recipe>
			 
    <merge from="root/res/values/sample.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/values/attrs.xml" />

    <instantiate from="root/src/app_package/CustomView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}.java" />
    <open file="${escapeXmlAttribute(resOut)}/values/${className}.xml" />
</recipe>
