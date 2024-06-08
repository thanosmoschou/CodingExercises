using Microsoft.AspNetCore.Mvc;
using RestApiLab5.Models;
using RestApiLab5.Repo;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace RestApiLab5.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BooksController : ControllerBase
    {
        private IBook _BookRepo;

        public BooksController(IBook bookRepo)
        {
            _BookRepo = bookRepo;
        }

        // GET: api/Books
        [HttpGet]
        public ActionResult<IEnumerable<Book>> GetBooks()
        {
            return _BookRepo.GetBooks().ToList();
        }

        // GET: api/Books/5
        [HttpGet("{id}")]
        public ActionResult<Book> GetBook(Guid id)
        {
            var book = _BookRepo.GetBook(id);
            if(book == null)
            {
                return NotFound();
            }
            return book;
        }

        // POST: api/Books
        [HttpPost]
        public Book CreateBook(CreateOrUpdateBookSchema book)
        {
            var myBook = new Book();
            myBook.Id = Guid.NewGuid();
            myBook.Title = book.Title;
            myBook.Price = book.Price;
            _BookRepo.CreateBook(myBook);
            return myBook;
        }

        // PUT: api/Books/5
        [HttpPut("{id}")]
        public ActionResult UpdateBook(Guid id, CreateOrUpdateBookSchema book)
        {
            var myBook = _BookRepo.GetBook(id);
            if(myBook == null)
            {
                return NotFound();
            }
            myBook.Title = book.Title;
            myBook.Price = book.Price;
            return Ok();

        }

        // DELETE: api/Books/5
        [HttpDelete("{id}")]
        public ActionResult DeleteBook(Guid id)
        {
            var mybook = _BookRepo.GetBook(id);
            if(mybook == null)
            {
                return NotFound();
            }
            _BookRepo.DeleteBook(id);
            return Ok();

        }
    }
}
