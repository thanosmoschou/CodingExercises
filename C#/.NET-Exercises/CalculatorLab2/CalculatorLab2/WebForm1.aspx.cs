using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CalculatorLab2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        // δήλωση της μεταβλητής της υπηρεσίας
        com.dneonline.www.Calculator myWS = new com.dneonline.www.Calculator();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            int a, b, apot;
            a = Convert.ToInt32(TextBox1.Text);
            b = Convert.ToInt32(TextBox2.Text);
            apot = myWS.Add(a, b);
            resLabel.Text = "Result: " + Convert.ToString(apot);
        }

        protected void btnDivide_Click(object sender, EventArgs e)
        {
            int a, b, apot;
            a = Convert.ToInt32(TextBox1.Text);
            b = Convert.ToInt32(TextBox2.Text);
            if (b != 0)
            {
                apot = myWS.Divide(a, b);
                resLabel.Text = "Result: " + Convert.ToString(apot);
            }
            else if (a != 0)
                resLabel.Text = "Αδύνατη πράξη";
            else
                resLabel.Text = "Αοριστία";
        }
    }
}