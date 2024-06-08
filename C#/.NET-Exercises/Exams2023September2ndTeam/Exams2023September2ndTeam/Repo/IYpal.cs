using Exams2023September2ndTeam.Model;

namespace Exams2023September2ndTeam.Repo
{
    public interface IYpal
    {
        public IEnumerable<Ypal> GetAllYpal();
        public Ypal GetYpal(String id);
        public void CreateYpal(Ypal ypal);
        //The following methods are not for the exams. There are just created for training purposes
        public void DeleteYpal(String id);
        public void UpdateYpal(String id, Ypal ypal);
    }
}
