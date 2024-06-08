using RestApiLab5.Models;

namespace RestApiLab5.Repo
{
    public class InMemBookRepo : IBook
    {
        private List<Book> _Books;

        public InMemBookRepo()
        {
            _Books = new(){new Book
                                { Id = Guid.NewGuid(), Title = "Book 0", Price = 10 } 
                          };
        }

        public void CreateBook(Book book)
        {
            _Books.Add(book);

            foreach (Book b in GetBooks())
            {
                Console.WriteLine(b.Title);
            }

        }

        public void DeleteBook(Guid id)
        {
            var myBookIndex = _Books.FindIndex(x=>x.Id == id);
            if(myBookIndex >  -1)
                _Books.RemoveAt(myBookIndex);


        }

        public Book GetBook(Guid id)
        {
            var book = _Books.Where(x => x.Id == id).SingleOrDefault();
            return book;
        }

        public IEnumerable<Book> GetBooks()
        {
            return _Books.ToList();
        }

        public void UpdateBook(Guid id, Book book)
        {
            var myBookIndex = _Books.FindIndex(x => x.Id == id);
            if(myBookIndex > -1)
                _Books[myBookIndex] = book;
        }
    }
}
