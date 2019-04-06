package smartCardUniversity.SHARED.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "id_genre", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "genre", length = 60, nullable = false)
	private String Genre;
	//
	@OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
	private List<Book> books;
	
	public Genre(Integer id, String genre, List<Book> books) {
		super();
		this.id = id;
		Genre = genre;
		this.books = books;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", Genre=" + Genre + ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
