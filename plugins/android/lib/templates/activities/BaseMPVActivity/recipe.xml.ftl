<?xml version="1.0"?>
<recipe>
	<merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
			 
	<!-- interface -->
	<instantiate from="root/src/app_package/IServe.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/I${className}Serve.java" />
				   
	<instantiate from="root/src/app_package/IView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/I${className}View.java" />
				   
	<!-- install -->
	<instantiate from="root/src/app_package/install/View.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/install/${activityClass}.java" />
				   
	<instantiate from="root/src/app_package/install/Serve.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/install/${className}Serve.java" />
				   
	<instantiate from="root/src/app_package/install/Handler.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/install/${className}Handler.java" />
	
	<!-- view struct -->
	<instantiate from="root/src/app_package/view_struct/IViewStruct.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view_struct/I${className}.java" />
				   
	<instantiate from="root/src/app_package/view_struct/ViewStructAdapter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view_struct/${className}Adapter.java" />
				   
	<!-- resource -->
	<instantiate from="root/src/app_package/layout/activity_layout.xml.ftl"
					to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
					
	<mkdir at="${escapeXmlAttribute(srcOut)}/component" />
	
	<!-- open  -->
	<open file="${escapeXmlAttribute(resOut)}/install/${activityClass}.java"/>
	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml"/>
</recipe>