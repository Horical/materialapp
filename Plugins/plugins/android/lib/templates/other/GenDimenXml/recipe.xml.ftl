<?xml version="1.0"?>
<recipe>

 
  <#if bDefaultDpi>
	<merge from="root/res/sample.xml.ftl"
                   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values/dimens.xml" />
  <#else>
	<merge from="root/res/sample-mdpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-mdpi/dimens.xml" />

	<merge from="root/res/sample-ldpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-ldpi/dimens.xml" />
			   
	<merge from="root/res/sample-hdpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-hdpi/dimens.xml" />
			   
	<merge from="root/res/sample-xhdpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-xhdpi/dimens.xml" />
			   
	<merge from="root/res/sample-xxhdpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-xxhdpi/dimens.xml" />
			   
	<merge from="root/res/sample-xxxhdpi.xml.ftl"
			   to="${escapeXmlAttribute(projectOut)}/${escapeXmlAttribute(location)}/values-xxxhdpi/dimens.xml" />
	
  </#if>
	
				   
</recipe>
