using Exams2023September2ndTeam.Model;

namespace Exams2023September2ndTeam.Repo
{
    public class YpalRepo : IYpal
    {
        private List<Ypal> ypals;

        public YpalRepo()
        {
            ypals = new List<Ypal>();
            ypals.Add(new Ypal("1", "Makis", "sinergeio@gmail.com"));
        }

        public void CreateYpal(Ypal ypal)
        {
            ypals.Add(ypal);
        }

        public void DeleteYpal(string id)
        {
            Ypal selected = findYpal(id);
            ypals.Remove(selected);
        }

        public IEnumerable<Ypal> GetAllYpal()
        {
            return ypals;
        }

        public Ypal GetYpal(string id)
        {
            return findYpal(id);
        }

        public void UpdateYpal(string id, Ypal ypal)
        {
            DeleteYpal(id);
            CreateYpal(ypal);
        }

        private Ypal findYpal(String id)
        {
            Ypal selected = null;

            for (int i = 0; i < ypals.Count; i++)
            {
                if (ypals[i].YpalID.Equals(id))
                {
                    selected = ypals[i];
                    break;
                }
            }

            return selected;
        }
    }
}
