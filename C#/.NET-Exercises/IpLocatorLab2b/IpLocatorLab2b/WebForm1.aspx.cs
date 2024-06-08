using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;

namespace IpLocatorLab2b
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        com.lavasoft.wsgeoip.GeoIPService geoWS = new com.lavasoft.wsgeoip.GeoIPService();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string country = geoWS.GetIpLocation(TextBox1.Text);
            XmlDocument doc = new XmlDocument();
            doc.LoadXml(country);

            XmlNodeList list = doc.DocumentElement.SelectNodes("//GeoIP"); //you can see the xml in the browser.
            string iso2code = list[0]["Country"].InnerText;
            lblCountry.Text = geoWS.GetCountryNameByISO2(iso2code);
            lblState.Text = list[0]["State"].InnerText;
        }
    }
}