using System.ComponentModel.DataAnnotations;

namespace Exams2023September2ndTeam.Model
{
    public class Ypal
    {
        [Required]
        public String YpalID { get; set; }
        [Required]
        public String YpalName { get; set; }
        [Required]
        public String YpalEmail { get; set; }

        public Ypal(string ypalID, string ypalName, string ypalEmail)
        {
            YpalID = ypalID;
            YpalName = ypalName;
            YpalEmail = ypalEmail;
        }
    }
}
