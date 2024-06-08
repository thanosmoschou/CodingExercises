using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MyConsumer
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        localhost.MyWService myWS = new localhost.MyWService();
        protected void Page_Load(object sender, EventArgs e)
        {
            lblServerTime.Text = myWS.ServerTime();
        }

        protected void btnCalculate_Click(object sender, EventArgs e)
        {
            // σε 2 ακέραιες μεταβλητές, υποδεχόμαστε ότι έδωσε ο χρήστης
            // ως απαραίτητη είσοδο για τη κλήση της μεθόδου CalculatePercentage()
            int myVal = Convert.ToInt32(tbMyValue.Text);
            int myTot = Convert.ToInt32(tbMyTotal.Text);
            // το αποτέλεσμα (ακέραιος) της μεθόδου της υπηρεσίας
            // μετατρέπεται σε string, για να εμφανιστεί μέσω του label lblPercentage
            lblPercentage.Text = Convert.ToString(myWS.CalculatePercentage(myTot, myVal)) + "%";
            lblPercentageLabel.Visible = true;
        }
    }
}