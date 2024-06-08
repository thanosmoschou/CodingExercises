using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            // HelloWS είναι ο "τύπος" που δημιούργησε η υπηρεσία HelloWS
            // η myHello είναι η μεταβλητή που δηλώνουμε, τύπου HelloWS
            HelloWS myHello = new HelloWS();

            //κλήση της μεθόδου Hello() της υπηρεσίας HelloWS
            Label1.Text = myHello.Hello();
        }
    }
}