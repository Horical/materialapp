<?xml version="1.0"?>
<globals>
	<global
        id="isLauncher"
        type="boolean"
        value="false" />

    <global
        id="backwardsCompatibility"
        type="boolean"
        value="true" />
    
	<global
        id="generateLayout"
        type="boolean"
        value="true"/>
		
	<global 
		id="className"
		type="string"
		value="${underscoreToCamelCase(classToResource(activityClass))}"/>
		
	<global id="hasNoActionBar" type="boolean" value="false" />
    <global id="simpleLayoutName" value="${layoutName}" />
    <global id="excludeMenu" type="boolean" value="true" />
    <global id="generateActivityTitle" type="boolean" value="false" />
	<global id="parentActivityClass" value="" />
	
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
	
	<#include "../common/common_globals.xml.ftl" />
</globals>