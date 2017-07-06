<?xml version="1.0"?>
<recipe>
			 
    <instantiate from="root/res/layout/sample.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/item_view_${view_class}.xml" />

    <instantiate from="root/src/app_package/CustomView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/Item${viewClass}Holder.java" />

    <open file="${escapeXmlAttribute(srcOut)}/Item${viewClass}Holder.java" />
    <open file="${escapeXmlAttribute(resOut)}/layout/item_view_${view_class}.xml" />
</recipe>
