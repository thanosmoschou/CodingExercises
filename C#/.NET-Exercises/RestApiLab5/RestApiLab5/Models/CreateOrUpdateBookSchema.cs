using System.ComponentModel.DataAnnotations;

namespace RestApiLab5.Models
{
    public record CreateOrUpdateBookSchema
    {
        [Required]
        public String? Title { get; set; }

        [Required]
        [Range(0, 100)]
        public decimal Price { get; set; }

    }
}
