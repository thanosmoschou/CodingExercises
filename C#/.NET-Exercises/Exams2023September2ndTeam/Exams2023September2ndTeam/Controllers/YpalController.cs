using Exams2023September2ndTeam.Model;
using Exams2023September2ndTeam.Repo;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Exams2023September2ndTeam.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class YpalController : ControllerBase
    {
        private IYpal repo;

        public YpalController(IYpal repo)
        { 
            this.repo = repo; 
        }

        // GET: api/<YpalController>
        [HttpGet]
        public ActionResult<IEnumerable<Ypal>> GetAllYpal()
        {
            return repo.GetAllYpal().ToList();
        }

        // GET api/<YpalController>/5
        [HttpGet("{id}")]
        public ActionResult<Ypal> GetYpal(String id)
        {
            return repo.GetYpal(id);
        }

        // POST api/<YpalController>
        [HttpPost]
        public void CreateYpal(Ypal ypal)
        {
            this.repo.CreateYpal(ypal);
        }

        // PUT api/<YpalController>/5
        [HttpPut("{id}")]
        public void UpdateYpal(String id, [FromBody] Ypal ypal)
        {
            this.repo.UpdateYpal(id, ypal);
        }

        // DELETE api/<YpalController>/5
        [HttpDelete("{id}")]
        public void DeleteYpal(String id)
        {
            this.repo.DeleteYpal(id);
        }
    }
}
