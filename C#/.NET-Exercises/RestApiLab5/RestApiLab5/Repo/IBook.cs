using RestApiLab5.Models;

namespace RestApiLab5.Repo
{
    public interface IBook
    {
        public IEnumerable<Book> GetBooks();
        public Book GetBook(Guid id);
        public void CreateBook(Book book);
        public void UpdateBook(Guid id, Book book);
        public void DeleteBook(Guid id);
    }
}
