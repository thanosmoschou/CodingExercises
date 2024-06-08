using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ExamsJanuary2023ThirdTeam
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        eu.dataaccess.footballpool.ws.Info ws = new eu.dataaccess.footballpool.ws.Info();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                eu.dataaccess.footballpool.ws.tTeamCoachName[] coaches = ws.AllTeamCoachNames();

                coachesDropDownList.Items.Add("Select a coach");
                for (int i = 0; i < coaches.Length; i++)
                    coachesDropDownList.Items.Add(coaches[i].sCoachName.ToString());
            }
        }

        protected void coachesDropDownList_SelectedIndexChanged(object sender, EventArgs e)
        {
            eu.dataaccess.footballpool.ws.tTeamCoachName[] coaches = ws.AllTeamCoachNames();
            eu.dataaccess.footballpool.ws.tPlayerName[] players = ws.AllPlayerNames(false);
            eu.dataaccess.footballpool.ws.tTeamCoachName selectedCoach = null;
            String selectedValueFromDropDown = coachesDropDownList.SelectedValue;

            for (int i = 0; i < coaches.Length; i++)
            {
                if (coaches[i].sCoachName.ToString().Equals(selectedValueFromDropDown))
                {
                    selectedCoach = coaches[i];
                    break;
                }
            }

            teamLabel.Text = selectedCoach.sTeamName.ToString();

            for (int i = 0; i < players.Length; i++)
            {
                if (players[i].sCountryName.ToString().Equals(selectedCoach.sTeamName.ToString()))
                {
                    teamFlag.ImageUrl = players[i].sCountryFlag.ToString();
                    break;
                }
            }
        }
    }
}