using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace testWS
{
    /// <summary>
    /// Summary description for MyWService
    /// </summary>
    [WebService(Namespace = "http://mywebservice.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class MyWService : System.Web.Services.WebService
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
