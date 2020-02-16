<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <xsl:element name="root">
            <xsl:apply-templates select="catalog/cd/artist"/>
        </xsl:element>
    </xsl:template>
    <xsl:template match="catalog/cd/artist">
        <xsl:element name="singer" >
            <xsl:value-of select="."/>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>