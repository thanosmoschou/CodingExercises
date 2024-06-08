using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab3Fifa
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        eu.dataaccess.footballpool.ws.Info fbWS = new eu.dataaccess.footballpool.ws.Info();
        protected void Page_Load(object sender, EventArgs e)
        {
            if(IsPostBack == false)
            {
                String[] stadiums = fbWS.StadiumNames();

                lstStadiumNames.Items.Add("Select stadium");

                for(int i = 0; i < stadiums.Length; i++)
                    lstStadiumNames.Items.Add(stadiums[i]);
            }
        }

        protected void lstTeamNames_SelectedIndexChanged(object sender, EventArgs e)
        {
            eu.dataaccess.footballpool.ws.tStadiumInfo stadium = fbWS.StadiumInfo(lstStadiumNames.Text);
            lblStadiumName.Text = stadium.sName + ", ";
            lblStadiumCity.Text = stadium.sCityName + ", ";
            lblStadiumCity.Text = Convert.ToString(stadium.iSeatsCapacity);
            googleMapsLink.Text = "Google Maps: Click here";
            googleMapsLink.NavigateUrl = stadium.sGoogleMapsURL;
            wikipediaLink.Text = stadium.sWikipediaURL;
            wikipediaLink.NavigateUrl = stadium.sWikipediaURL;

            iframePH.Controls.Add(new LiteralControl("<iframe src = \"" + stadium.sWikipediaURL + "\"" +
                "width = 600 height = 300 runat = \"server\" </iframe>"));

            lblStadiumName.Visible = true;
            lblStadiumCity.Visible = true;
            lblStadiumCapacity.Visible = true;
            googleMapsLink.Visible = true;
            wikipediaLink.Visible = true;
        }
    }
}