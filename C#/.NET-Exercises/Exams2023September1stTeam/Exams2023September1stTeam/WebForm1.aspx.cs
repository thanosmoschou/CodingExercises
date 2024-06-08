using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Exams2023September1stTeam
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        Sept2023Exams ws1 = new Sept2023Exams();
        org.oorsprong.www.CountryInfoService ws2 = new org.oorsprong.www.CountryInfoService();

        protected void Page_Load(object sender, EventArgs e)
        {
            if(IsPostBack == false)
            {
                org.oorsprong.www.tCountryCodeAndName[] countries = ws2.ListOfCountryNamesByName();

                countriesDropDown.Items.Add("Select a country");
                for (int i = 0; i < countries.Length; i++)
                    countriesDropDown.Items.Add(countries[i].sName.ToString());
            }
        }

        protected void evenOrOddButton_Click(object sender, EventArgs e)
        {
            int num = Convert.ToInt32(numInput.Text);
            evenOrOddResult.Text = ws1.Zigos(num);
        }

        protected void countriesDropDown_SelectedIndexChanged(object sender, EventArgs e)
        {
            String selected = countriesDropDown.SelectedValue;
            String iso = ws2.CountryISOCode(selected);
            String capital = ws2.CapitalCity(iso);

            isoLabel.Text = iso;
            capitalLabel.Text = capital;
        }
    }
}