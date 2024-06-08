using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace StadiumInfoLab2b
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        eu.dataaccess.footballpool.ws.Info st = new eu.dataaccess.footballpool.ws.Info();

        protected void Page_Load(object sender, EventArgs e)
        {
            if(IsPostBack == false)
            {
                // If you see the xml in the browser it is something like the following
                /*
                 * <ArrayOftStadiumInfo>
                    <tStadiumInfo>
                    <sName>Ahmad bin Ali Stadium</sName>
                    <iSeatsCapacity>44740</iSeatsCapacity>
                    <sCityName>Al Rayyan</sCityName>
                    <sWikipediaURL>https://en.wikipedia.org/wiki/Ahmad_bin_Ali_Stadium</sWikipediaURL>
                    <sGoogleMapsURL>https://www.google.com/maps/place/Ahmed+bin+Ali+Stadium/@25.329442,51.3400615,17z/data=!3m1!4b1!4m5!3m4!1s0x3e4675cdff99e939:0x33f2dc1b4db9730c!8m2!3d25.3294372!4d51.3422502</sGoogleMapsURL>
                    </tStadiumInfo>

                    So you can see that it returns an array of tStadiumInfo.
                    Each tStadiumInfo element has the following fields:
                    sName, iSeatsCapacity, sWikipediaURL, sGoogleMapsURL
                    So due to the fact that this is an array of objects, you can access each attribute with dot notation
                    for example stadiumNames[i].sName
                 */

                eu.dataaccess.footballpool.ws.tStadiumInfo[] stadiumNames = st.AllStadiumInfo();
                DropDownList1.Items.Add("Select");

                for (int i = 0; i < stadiumNames.Length; i++)
                    DropDownList1.Items.Add(stadiumNames[i].sName);
            }

        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Console.WriteLine("ok");
            eu.dataaccess.footballpool.ws.tStadiumInfo stUrl = st.StadiumInfo(DropDownList1.Text);
            stadiumNameLabel.Text = DropDownList1.Text;
            capacityLabel.Text = stUrl.iSeatsCapacity.ToString();
            cityLabel.Text = stUrl.sCityName;
            google.NavigateUrl = stUrl.sGoogleMapsURL;
            wikipedia.NavigateUrl = stUrl.sWikipediaURL;

        }
    }
}