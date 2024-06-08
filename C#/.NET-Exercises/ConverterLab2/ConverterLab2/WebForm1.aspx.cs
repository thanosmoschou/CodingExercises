using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;

namespace ConverterLab2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        lt.lb.www.ExchangeRates myWS2 = new lt.lb.www.ExchangeRates();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false) // αν είναι η πρώτη φορά που φορτώνει η σελίδα
            {
                // λαμβάνω σε XML κόμβο‐ρίζα <Currencies> τα διαθέσιμα νομίσματα,
                // πχ. «EUR», «GBP» κλπ.
                // Εχω κομβο ριζα <Currencies> οπου μεσα εχει κομβους <item>
                // Καλεσε απο browser την υπηρεσια για να δεις το xml.
                XmlNode node = myWS2.getListOfCurrencies();
                // οι XML κόμβοι μέσα στη ρίζα είναι της μορφής <item>. Θελει // και το ονομα του tag.
                XmlNodeList nodes = node.SelectNodes("//item");
                //Διαπερνάμε τους xml nodes και βάζουμε όποια πεδία τους θέλουμε
                //στις πτυσσόμενες λίστες
                foreach (XmlNode nd in nodes)
                {
                    // Εχω μια λιστα απο nodes. Διατρεχω καθε κομβο και αναθετω την τιμη στην μεταβλητη nd.
                    // Μεσα στο <item> εχω αλλες ετικετες. Με nd["tagName"] παιρνω την εσωτερικη ετικετα που υπαρχει στο item.
                    lstCurFrom.Items.Add(nd["currency"].InnerText + " " +
                    nd["description"].InnerText);
                    lstCurTo.Items.Add(nd["currency"].InnerText + " " +
                    nd["description"].InnerText);
                }
                lstCurFrom.SelectedIndex = 26;
                //αρχικοποιούμε στο Ευρώ την πρώτη λίστα
                lstCurTo.SelectedIndex = 27;
                //αρχικοποιούμε στην Αγγλική Λίρα την δεύτερη λίστα
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            decimal f, rateFrom = 0, rateTo = 0;
            string n1, n2;
            n1 = Convert.ToString(lstCurFrom.SelectedItem).Substring(0, 3);
            n2 = Convert.ToString(lstCurTo.SelectedItem).Substring(0, 3);
            //Δυστυχώς μόνο για ιστορικά στοιχεία λειτουργεί αυτή η free Web
            //Υπηρεσία
            // Λαμβάνω σε XML κόμβο‐ρίζα <ExchangeRates> την αντιστοιχία
            XmlNode node = myWS2.getExchangeRatesByDate("2014‐12‐31");
            // οι XML κόμβοι μέσα στη ρίζα είναι και εδώ της μορφής <item>
            XmlNodeList nodes = node.SelectNodes("//item");
            //Διαπέραση των xml nodes
            foreach (XmlNode nde in nodes)
            {
                if (nde["currency"].InnerText == n1)
                    // εντοπίζουμε το νόμισμα της πρώτης λίστας (προέλευση)
                    // η ισοτιμία δίνεται στα διάφορα νομίσματα σε διαφορετικές
                    //ποσότητες...
                    rateFrom = Convert.ToDecimal(nde["rate"].InnerText) / Convert.ToInt32(nde["quantity"].InnerText);
                if (nde["currency"].InnerText == n2)
                    // εντοπίζουμε το νόμισμα της δεύτερης λίστας (προορισμός)
                    // και εδώ χρειάζεται αναγωγή στη μονάδα
                    rateTo = Convert.ToDecimal(nde["rate"].InnerText) / Convert.ToInt32(nde["quantity"].InnerText);
            }
            // ακρίβεια 2 δεκαδικών ψηφίων
            f = Math.Round(Convert.ToDecimal(TextBox1.Text) * rateFrom / rateTo, 2);
            resLabel.Text = Convert.ToString(f);
        }
    }
}