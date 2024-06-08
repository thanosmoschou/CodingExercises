using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ExamsJuly2023
{
    /// <summary>
    /// Summary description for ExamsJuly2023
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ExamsJuly2023 : System.Web.Services.WebService
    {

        [WebMethod]
        public List<int> IntDivision(int num1, int num2)
        {
            int quot = 0, rem = 0;

            quot = Math.DivRem(num1, num2, out rem);
            return new List<int> { quot, rem };
        }

        [WebMethod]
        public String MiddleWord(String inputWord)
        {
            int indexOfFirstSpace = inputWord.IndexOf(" ");
            String tmpWord = inputWord.Substring(indexOfFirstSpace + 1);

            int indexOfSecondSpace = tmpWord.IndexOf(" ");
            String result = tmpWord.Substring(0, indexOfSecondSpace);

            return result;
        }
    }
}
