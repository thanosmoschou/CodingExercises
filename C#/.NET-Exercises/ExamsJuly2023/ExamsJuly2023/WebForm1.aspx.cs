using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ExamsJuly2023
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        ExamsJuly2023 ws = new ExamsJuly2023();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void checkButton_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(firstNumInput.Text);
            int num2 = Convert.ToInt32(secondNumInput.Text);

            List<int> result = ws.IntDivision(num1, num2);

            quotLabel.Text = result[0].ToString();
            remLabel.Text = result[1].ToString();
        }

        protected void separateButton_Click(object sender, EventArgs e)
        {
            String text = textInput.Text;
            String result = ws.MiddleWord(text);

            textOutput.Text = result;
        }
    }
}