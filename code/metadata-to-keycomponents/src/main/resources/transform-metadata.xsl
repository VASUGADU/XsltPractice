<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
    <xsl:template match="/">
        <xsl:element name="keyComponents">
            <xsl:apply-templates select="NetworkBuildConfigMetadata/KeyComponentTypes/KeyComponentType"/>
        </xsl:element>
    </xsl:template>
    <xsl:template match="NetworkBuildConfigMetadata/KeyComponentTypes/KeyComponentType">
        <xsl:element name="keyComponent">
            <xsl:element name="name">
                <xsl:value-of select="Name"/>
            </xsl:element>
            <xsl:element name="dataType" >
                <xsl:value-of select="Detail/KeyComponentDataType"/>
            </xsl:element>
            <xsl:element name="coldLists" >
                <xsl:if test="ColdlistEntries != ''">
                    <xsl:element name="coldList" >
                        <xsl:element name="term" >
                            <xsl:value-of select="ColdlistEntries/ColdlistEntry/Term"/>
                        </xsl:element>
                        <xsl:element name="matchType" >
                            <xsl:value-of select="ColdlistEntries/ColdlistEntry/MatchType"/>
                        </xsl:element>
                    </xsl:element>
                </xsl:if>
            </xsl:element>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>