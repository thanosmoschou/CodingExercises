using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace TestWS
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://mywebservice.org")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]

    public class WebService1 : System.Web.Services.WebService
    {

        [WebMethod]
        public string ServerTime()
        {
            string st;
            st = DateTime.Now.ToString();
            return st;
        }

        [WebMethod]
        public int CalculatePercentage(int myTotal, int myValue)
        {
            int cp;
            cp = (int)myValue * 100 / myTotal;
            return cp;
        }
    }
}
