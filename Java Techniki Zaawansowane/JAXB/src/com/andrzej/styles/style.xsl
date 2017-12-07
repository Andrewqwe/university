<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:variable name="zyczenia" select="document('../resources/zycz.xml')"></xsl:variable>
    <xsl:variable name="address" select="document('../resources/dane.xml')"></xsl:variable>
    <xsl:template match="/">
        <html>
            <body>
                <h2>Kartka swiateczna</h2>
                <table>
                    <tr bgcolor="#9acd64">
                        <th>imie</th>
                        <th>nazwisko</th>
                        <th>miasto</th>
                        <th>adres</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="$address/daneAdresowe/imie"/>
                        </td>
                        <td>
                            <xsl:value-of select="$address/daneAdresowe/nazwisko"/>
                        </td>
                        <td>
                            <xsl:value-of select="$address/daneAdresowe/miasto"/>
                        </td>
                        <td>
                            <xsl:value-of select="$address/daneAdresowe/adres"/>
                        </td>
                    </tr>
                </table>
                <h2>
                    <xsl:value-of select="$zyczenia/zyczenia/tytul"></xsl:value-of>
                </h2>
                <p>
                    <xsl:value-of select="$zyczenia/zyczenia/tresc"></xsl:value-of>
                </p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>