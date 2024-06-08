using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CountriesLab2b
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        org.oorsprong.www.CountryInfoService ct = new org.oorsprong.www.CountryInfoService();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                lstCountry.Items.Add("‐Select‐");
                // η μέθοδος επιστρέφει έναν πίνακα tCountryCodeAndName[]
                // ΠΡΟΣΟΧΗ λοιπόν στον τρόπο δήλωσης (τύπο) της μεταβλητής μας
                org.oorsprong.www.tCountryCodeAndName[] can =
                ct.ListOfCountryNamesByName();
                for (int i = 0; i < can.Length; i++)
                    lstCountry.Items.Add(can[i].sName);
            }
        }
       


        protected void btnCountry_Click(object sender, EventArgs e)
        {
            string strIsoCountry = ct.CountryISOCode(lstCountry.Text);
            lblIsoCode.Text = strIsoCountry;
            string strCapital = ct.CapitalCity(strIsoCountry);
            lblCapital.Text = strCapital;
            string strImage = ct.CountryFlag(strIsoCountry);
            Image1.ImageUrl = strImage;
            string strPhone = ct.CountryIntPhoneCode(strIsoCountry);
            lblPhone.Text = strPhone;

            org.oorsprong.www.tCurrency cur = ct.CountryCurrency(strIsoCountry);
            lblCurrency.Text = cur.sName + "(" + cur.sISOCode + ")";
        }

        protected void lstCountry_SelectedIndexChanged(object sender, EventArgs e)
        {
            string strIsoCountry = ct.CountryISOCode(lstCountry.Text);
            lblIsoCode.Text = strIsoCountry;
            string strCapital = ct.CapitalCity(strIsoCountry);
            lblCapital.Text = strCapital;
            string strImage = ct.CountryFlag(strIsoCountry);
            Image1.ImageUrl = strImage;
            string strPhone = ct.CountryIntPhoneCode(strIsoCountry);
            lblPhone.Text = strPhone;
        }
    }
}