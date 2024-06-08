using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab3
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        eu.dataaccess.footballpool.ws.Info fbWS = new eu.dataaccess.footballpool.ws.Info();

        protected void Page_Load(object sender, EventArgs e)
        {
            // If the page has not loaded this variable is false. If it has loaded at least one time it has true value.
            if(IsPostBack == false)
            {
                string[] teamTable = fbWS.TeamNames();

                lstTeamNames.Items.Add("Choose team");

                for(int i = 0; i < teamTable.Length; i++)
                    lstTeamNames.Items.Add(teamTable[i]);  
            }
        }

        protected void lstTeamNames_SelectedIndexChanged(object sender, EventArgs e)
        {
            eu.dataaccess.footballpool.ws.tPlayer[] player = fbWS.TeamPlayers(lstTeamNames.Text, true);
            eu.dataaccess.footballpool.ws.tPlayer[] playerNS = fbWS.TeamPlayers(lstTeamNames.Text, false);

            lstTeamPlayers.Items.Clear();
            lstTeamPlayersNS.Items.Clear();

            //You have an array of tPlayer objects. With . and the wanted attribute name you can access that value.
            for(int i = 0; i < player.Length; i++)
                lstTeamPlayers.Items.Add(player[i].sName);
            
            for(int i = 0; i < playerNS.Length; i++)
                lstTeamPlayersNS.Items.Add(playerNS[i].sName);

            lstTeamPlayers.Visible = true;
            lstTeamPlayersNS.Visible = true;
            lblSumPlayers.Text = "(" + Convert.ToString(player.Length) + ")";
            lblSumPlayersNS.Text = "(" + Convert.ToString(playerNS.Length) + ")";
            lblPlayers.Visible = true;
            lblPlayersNS.Visible = true;
            lblSumPlayers.Visible = true;
            lblSumPlayersNS.Visible = true;
        }

        
    }
}