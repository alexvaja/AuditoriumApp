package smartCardUniversity.SHARED.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_booking")
public class BookBooking {
	
	@Id
	@Column(name = "id_book_booking", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser userBook;
	
	@Column(name = "booking_day", nullable = false)
	private Date bookingDay;
	
	@Column(name = "refund_day", nullable = false)
	private Date refundDay;
	
	@Column(name = "is_refund", nullable = false)
	private Boolean isRefund;

	
	
	public BookBooking(Integer id, Book book, AppUser userBook, Date bookingDay, Date refundDay, Boolean isRefund) {
		super();
		this.id = id;
		this.book = book;
		this.userBook = userBook;
		this.bookingDay = bookingDay;
		this.refundDay = refundDay;
		this.isRefund = isRefund;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public AppUser getUserBook() {
		return userBook;
	}
	public void setUserBook(AppUser userBook) {
		this.userBook = userBook;
	}
	public Date getBookingDay() {
		return bookingDay;
	}
	public void setBookingDay(Date bookingDay) {
		this.bookingDay = bookingDay;
	}
	public Date getRefundDay() {
		return refundDay;
	}
	public void setRefundDay(Date refundDay) {
		this.refundDay = refundDay;
	}
	public Boolean getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(Boolean isRefund) {
		this.isRefund = isRefund;
	}

	
	@Override
	public String toString() {
		return "BookBooking [id=" + id + ", book=" + book + ", userBook=" + userBook + ", bookingDay=" + bookingDay
				+ ", refundDay=" + refundDay + ", isRefund=" + isRefund + "]";
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
		BookBooking other = (BookBooking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
