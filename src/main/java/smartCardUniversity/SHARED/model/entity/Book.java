package smartCardUniversity.SHARED.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "id_book", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title", length = 120, nullable = false)
	private String title;
	
	@Column(name = "isbn", length = 60, nullable = false)
	private String ISBN;
	
	@ManyToOne
	@JoinColumn(name = "access_id", nullable = false)
	private Access access;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn(name = "genre_id", nullable = false)
	private Genre genre;
	
	@Column(name = "year", length = 60, nullable = false)
	private String year;
	//
	
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private List<BookBooking> bookBookings;
	
	@ManyToMany(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "book_author",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "author_id") }
			)
	private List<Author> authors;

	public Book() 
	{
		super();
	}
	public Book(Integer id, String title, String iSBN, Access access, Publisher publisher, Genre genre, String year,
			List<BookBooking> bookBookings, List<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		ISBN = iSBN;
		this.access = access;
		this.publisher = publisher;
		this.genre = genre;
		this.year = year;
		this.bookBookings = bookBookings;
		this.authors = authors;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<BookBooking> getBookBookings() {
		return bookBookings;
	}

	public void setBookBookings(List<BookBooking> bookBookings) {
		this.bookBookings = bookBookings;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", access=" + access + ", publisher="
				+ publisher + ", genre=" + genre + ", year=" + year + ", bookBookings=" + bookBookings + ", authors="
				+ authors + "]";
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
